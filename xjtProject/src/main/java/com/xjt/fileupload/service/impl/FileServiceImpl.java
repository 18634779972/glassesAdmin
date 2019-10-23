package com.xjt.fileupload.service.impl;


import com.xjt.fileupload.common.FileConst;
import com.xjt.fileupload.common.ServerResponse;
import com.xjt.fileupload.service.IFileService;
import com.xjt.fileupload.util.MinioUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 文件上传服务
 */

public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    //private final String baseDir = FileConst.baseDir;

    private String ip = FileConst.ip;
    private int port = FileConst.port;
    private String username = FileConst.username;
    private String password = FileConst.password;

    /**
     * @param file           上传指定文件
     * @param remoteFileName 上传到服务器的文件名
     * @param localPath      本地临时存放路径
     * @param folder         传至FTP指定文件夹
     * @return 上传结果
     */
    @Override
    public ServerResponse upload(MultipartFile file, String remoteFileName, String localPath, String folder) {

        ServerResponse serverResponse;

        /*if (StringUtils.isBlank(folder) || folder.equals("/")) {
            folder = baseDir + "/";
        }*/

        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取后缀名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;

        logger.info("准备上传文件: 上传文件的文件名({}),上传的路径({}),新文件名({})", new String[]{fileName, folder, uploadFileName});

        File fileDir = new File(localPath);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(localPath, uploadFileName);
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            return ServerResponse.createByErrorMessage("保存" + fileName + "到本地失败");
        }

        /*serverResponse = FTPUtil.uploadFile(Lists.newArrayList(targetFile), Lists.newArrayList(remoteFileName),
                folder, ip, port, username, password);*/
        serverResponse = MinioUtil.getInstance().saveFile(folder, targetFile, remoteFileName);
        targetFile.delete();

        if (serverResponse.isSuccess()) {
            if (StringUtils.isNotBlank(folder) && !"/".equals(folder)) {
                uploadFileName = folder + "/" + uploadFileName;
            }
            return ServerResponse.createBySuccessMessage(uploadFileName);
        } else {
            return serverResponse;
        }
    }

    /**
     * @param file           上传指定文件
     * @param remoteFileName 上传到服务器的文件名
     * @param folder         上传至FTP指定文件夹
     * @return
     */
    @Override
    public ServerResponse upload(File file, String remoteFileName, String folder) {

        ServerResponse serverResponse;

        logger.info("准备上传文件: 上传的路径({}), 上传的文件名({})", folder, file.getName());

        /*serverResponse = FTPUtil.uploadFile(Lists.newArrayList(file), Lists.newArrayList(remoteFileName),
                folder, ip, port, username, password);*/
        serverResponse = MinioUtil.getInstance().saveFile(folder, file, remoteFileName);

        logger.info("上传结果: ({})", serverResponse.isSuccess() ? "成功" : "失败");

        if (serverResponse.isSuccess()) {
            //String uploadFileName = file.getName();
            String uploadFileName = remoteFileName;
            if (StringUtils.isNotBlank(folder) && !"/".equals(folder)) {
                uploadFileName = folder + "/" + uploadFileName;
            }
            return ServerResponse.createBySuccess(uploadFileName);
        } else {
            return serverResponse;
        }
    }

    @Override
    public ServerResponse delete(String folder, String filename) {
        //return FTPUtil.deleteFile(fileUrl, ip, port, username, password);
        //TODO
        return MinioUtil.getInstance().deleteFile(folder, filename);
    }

    @Override
    public ServerResponse<File> download(String folder, String filename) {
        //return FTPUtil.downloadFile(fileUrl, ip, port, username, password);
        //TODO
        return MinioUtil.getInstance().getFile(folder, filename);
    }

    @Override
    public ServerResponse<File> downloadPro(String folder, String filename, String rootFolderFile, String projectName, String originFullName) {
        //return FTPUtil.downloadFile(fileUrl, ip, port, username, password);
        //TODO
        return MinioUtil.getInstance().getProFile(folder, filename, rootFolderFile, projectName, originFullName);
    }

    /*@Override
    public boolean connectFtpServer() {
        return FTPUtilOld.connectFtpServer(ip, port, username, password);
    }*/
}
