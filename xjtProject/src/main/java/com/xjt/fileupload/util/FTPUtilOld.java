package com.xjt.fileupload.util;


import com.xjt.fileupload.common.FileConst;
import com.xjt.fileupload.common.ResponseCode;
import com.xjt.fileupload.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * FTP文件上传功能
 */
public class FTPUtilOld {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtilOld.class);

    private final String tmpDir = System.getProperty("java.io.tmpdir");

    //本地字符编码
    private String LOCAL_CHARSET = "GBK";
    // FTP协议里面，规定文件名编码为iso-8859-1
    private String SERVER_CHARSET = "ISO-8859-1";

    //ftp连接客户端
    private FTPClient ftpClient;

    private String ip;
    private int port;
    private String username;
    private String password;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private FTPUtilOld(String ip, int port, String username, String password) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public static FTPUtilOld getInstance(String ip, int port, String user, String pwd) {
        return new FTPUtilOld(ip, port, user, pwd);
    }

    //创建多层级文件夹
    private void createFtpDir(String ftpFolder) throws IOException {

        String[] folders = ftpFolder.split("/");
        LinkedList<String> folderList = new LinkedList<>();
        for (String folder : folders) {
            if (StringUtils.isNotBlank(folder)) {
                folderList.offer(folder);
            }
        }

        while (folderList.size() > 0) {
            String folder = folderList.poll();
            ftpClient.makeDirectory(folder);
            ftpClient.changeWorkingDirectory(ftpClient.printWorkingDirectory() + "/" + folder);
        }
    }

    //路径转码为UTF-8
    private String urlEncodingToUTF8(String ftpFolder) {
        try {
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
                LOCAL_CHARSET = "UTF-8";
            }
            ftpClient.setControlEncoding(LOCAL_CHARSET);
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
            conf.setServerLanguageCode("zh");
            ftpClient.configure(conf);

            //return new String(ftpFolder.getBytes(LOCAL_CHARSET), SERVER_CHARSET);

            if (StringUtils.isBlank(ftpFolder) || ftpFolder.equals("/")) {
                return FileConst.baseDir;
            } else {
                return new String(ftpFolder.getBytes(LOCAL_CHARSET), SERVER_CHARSET);
            }
        } catch (Exception e) {
            return ftpFolder;
        }
    }

    /**
     * 内部的FTP上传功能
     *
     * @param fileList           上传的文件列表
     * @param remoteFileNameList 上传到服务器的文件名列表
     * @param ftpFolder          上传到指定文件夹
     * @return 上传结果
     */
    private ServerResponse upload(List<File> fileList, List<String> remoteFileNameList, String ftpFolder) {
        ServerResponse serverResponse;
        FileInputStream fis = null;
        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.username, this.password)) {
            try {
                ftpFolder = urlEncodingToUTF8(ftpFolder);

                //如果不能进入dir下，说明此目录不存在
                if (!ftpClient.changeWorkingDirectory(ftpFolder)) {
                    createFtpDir(ftpFolder);
                }

                ftpClient.changeWorkingDirectory(ftpFolder);
                ftpClient.setBufferSize(1024);

                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                for (int i = 0; i < fileList.size(); i++) {
                    File fileItem = fileList.get(i);
                    String fileName;
                    if (remoteFileNameList != null && remoteFileNameList.size() >= i) {
                        fileName = new String(remoteFileNameList.get(i).getBytes(LOCAL_CHARSET), SERVER_CHARSET);
                    } else {
                        fileName = new String(fileItem.getName().getBytes(LOCAL_CHARSET), SERVER_CHARSET);
                    }

                    fis = new FileInputStream(fileItem);
                    boolean b = ftpClient.storeFile(fileName, fis);
                    fis.close();
                }
                serverResponse = ServerResponse.createBySuccess();
            } catch (IOException e) {
                logger.error("上传文件异常", e);
                serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FTP_FAILED.getCode(),
                        "上传文件至FTP服务器异常:" + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                    ftpClient.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FTP_FAILED.getCode(),
                    "连接FTP服务器失败，请检查配置");
        }
        return serverResponse;
    }

    /**
     * 从FTP服务器删除文件
     *
     * @param filepath  文件在服务器上的路径
     * @return          删除结果
     */
    private ServerResponse delete(String filepath) {
        ServerResponse serverResponse;

        if (connectServer(this.ip, this.port, this.username, this.password)) {
            try {
                filepath = urlEncodingToUTF8(filepath);
                //如果不能进入dir下，说明此目录不存在
                boolean success = ftpClient.deleteFile(filepath);
                serverResponse = ServerResponse.createBySuccess("文件删除结果:" + (success ? "成功" : "失败"));
            } catch (IOException e) {
                logger.error("删除文件异常", e);
                serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FTP_FAILED.getCode(),
                        "从FTP服务器删除文件 " + filepath + " 异常:" + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    ftpClient.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FTP_FAILED.getCode(),
                    "连接FTP服务器失败，请检查配置");
        }
        return serverResponse;
    }

    private ServerResponse<File> download(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());

        File localFile = new File(tmpDir + File.separator + fileName);

        ServerResponse<File> serverResponse = null;

        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.username, this.password)) {
            filePath = urlEncodingToUTF8(filePath);
            try {
                OutputStream outputStream = new FileOutputStream(localFile);
                boolean success = ftpClient.retrieveFile(filePath, outputStream);
                outputStream.close();
                if (success) {
                    serverResponse = ServerResponse.createBySuccess(localFile);
                } else {
                    serverResponse = ServerResponse.createByErrorMessage("获取文件失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("获取文件异常: " + e.getMessage());
                serverResponse = ServerResponse.createByErrorMessage("获取文件异常: " + e.getMessage());
            }
        } else {
            serverResponse = ServerResponse.createByErrorCodeMessage(ResponseCode.FTP_FAILED.getCode(),
                    "连接FTP服务器失败，请检查配置");
        }

        return serverResponse;
    }

    /**
     * 检测是否可以连接到指定FTP服务器
     *
     * @param ip        FTP服务器ip地址
     * @param port      FTP服务器端口
     * @param username  FTP服务器用户名
     * @param password  FTP服务器密码
     * @return          测试结果
     */
    private boolean connectServer(String ip, int port, String username, String password) {

        boolean isSuccess;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(username, password);
        } catch (Exception e) {
            isSuccess = false;
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }

    /**
     * 测试是否可以连接到FTP服务器，对外部提供
     *
     * @param ip        FTP服务器地址
     * @param port      FTP服务器端口
     * @param username  FTP服务器用户名
     * @param password  FTP服务器密码
     * @return          测试结果
     */
    public static boolean connectFtpServer(String ip, int port, String username, String password) {
        logger.info("测试连接ftp服务器: 地址({}) 端口({}) 用户名({}) 密码({})",
                new String[]{ip, Integer.toString(port), username, password});
        FTPUtilOld ftpUtil = FTPUtilOld.getInstance(ip, port, username, password);
        return ftpUtil.connectServer(ip, port, username, password);
    }

    /**
     * 向外部提供的FTP上传方法
     *
     * @param fileList           上传的文件列表
     * @param remoteFileNameList 上传到服务器的文件名列表
     * @param ftpFolder          上传到指定文件夹
     * @param ip                 FTP服务器ip地址
     * @param port               FTP服务器端口
     * @param username           FTP服务器用户名
     * @param password           FTP服务器密码
     * @return 上传结果
     */
    public static ServerResponse uploadFile(List<File> fileList, List<String> remoteFileNameList,
                                            String ftpFolder, String ip, int port, String username, String password) {
        FTPUtilOld ftpUtil = FTPUtilOld.getInstance(ip, port, username, password);
        return ftpUtil.upload(fileList, remoteFileNameList, ftpFolder);
    }

    /**
     *
     * @param fileUrl   文件路径
     * @param ip        FTP服务器ip地址
     * @param port      FTP服务器端口
     * @param username  FTP服务器用户名
     * @param password  FTP服务器密码
     * @return          删除结果
     */
    public static ServerResponse deleteFile(String fileUrl, String ip, int port, String username, String password) {
        FTPUtilOld ftpUtil = FTPUtilOld.getInstance(ip, port, username, password);
        return ftpUtil.delete(fileUrl);
    }

    /**
     *
     * @param fileUrl   文件路径
     * @param ip        FTP服务器ip地址
     * @param port      FTP服务器端口
     * @param username  FTP服务器用户名
     * @param password  FTP服务器密码
     * @return          删除结果
     */
    public static ServerResponse<File> downloadFile(String fileUrl, String ip, int port, String username, String password) {
        FTPUtilOld ftpUtil = FTPUtilOld.getInstance(ip, port, username, password);
        return ftpUtil.download(fileUrl);
    }
}
