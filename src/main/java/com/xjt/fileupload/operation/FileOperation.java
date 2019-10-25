package com.xjt.fileupload.operation;


import com.google.common.collect.Lists;
import com.xjt.fileupload.common.FileConst;
import com.xjt.fileupload.common.ServerResponse;
import com.xjt.fileupload.common.YesOrNo;
import com.xjt.fileupload.pojo.FileHistory;
import com.xjt.fileupload.service.IFileService;
import com.xjt.fileupload.util.FileUtil;
import com.xjt.fileupload.util.VerifyFileTypeUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author 刘威
 * @Date 2018.04.28
 * @Description 普通文件操作类，不进行格式转换
 */


public class FileOperation {

    
    private IFileService iFileService;

    private final Logger logger = LoggerFactory.getLogger(FileOperation.class);
    private final String separator = File.separator;
    //private final String baseDir = FileConst.baseDir;
    private final String qrcodeDir = FileConst.qrcodeDir;

    /**
     * 文件保存处理
     *
     * @param sourceFile 来源文件
     * @param folder     文件配置
     * @return 结果
     */
    public ServerResponse<ArrayList<FileHistory>> complete(File sourceFile, String folder) {

        ServerResponse<ArrayList<FileHistory>> serverResponse;

        //根据路径生成文件
        String sourceFilePath = sourceFile.getPath();

        if (!sourceFile.exists()) {
            logger.error("文件不存在");
            return ServerResponse.createByErrorMessage("文件" + sourceFile.getPath() + "不存在");
        }

        //原文件所在目录
        String sourceFileDir = sourceFile.getParent();
        //原文件真实格式
        String sourceRealType = VerifyFileTypeUtil.getFileType(sourceFile);
        //如果没有格式，说明文件不是支持的格式
        if (sourceRealType.length() <= 1) {
            logger.error("文件格式不支持 {}", sourceFilePath);
            return ServerResponse.createByErrorMessage("文件" + sourceFile.getName() + "不是支持的文件格式");
        }

        folder = FileUtil.formatFolder(folder);

        //文件输出目录字符串
        String outOfficeDirStr = "";
        //判断处理url是相对路径还是绝对路径
        if (folder.contains(":")) {
            //绝对路径
            outOfficeDirStr = folder;
        } else {
            //相对路径
            outOfficeDirStr = sourceFileDir + separator + folder;
        }

        //文件输出目录
        File outOfficeDir = new File(outOfficeDirStr);
        //判断保存文件的路径是否存在，不存在则建立文件夹
        if (!outOfficeDir.exists()) {
            outOfficeDir.mkdirs();
        }

        //生成保存的文件名
        String saveNewFileName = FileUtil.getNewFileName() + "." + sourceRealType;
        //无需转换，直接上传至指定目录
        ServerResponse originServerResponse = saveToFtp(sourceFile, saveNewFileName, folder);

        //如果保存成功，则将URL信息写入响应内容
        if (originServerResponse.isSuccess()) {
            //如果成功创建新的文件记录
            FileHistory fileHistory = FileHistory.createFileHistory(new Date(), saveNewFileName, folder,
                    YesOrNo.YES.getValue(), sourceFile.getName(), sourceRealType,
                    "权限信息","操作人信息", "备注信息");

            //如果是图片格式，则将宽高信息保存
            if (VerifyFileTypeUtil.isImageFile(sourceFile)) {
                addWidthAndHeight(fileHistory, sourceFile);
            }
            //将文件记录传入到响应信息中
            serverResponse = ServerResponse.createBySuccess(Lists.newArrayList(fileHistory));
        } else {
            //如果保存失败则将错误信息拷贝进响应信息
            serverResponse = ServerResponse.createByErrorMessage(originServerResponse.getMsg());
        }

        //删除本地临时原文件
        /*if (sourceFile.exists()) {
            sourceFile.delete();
        }*/
        return serverResponse;
    }

    public ServerResponse saveQrcode(File sourceFile) {

        ServerResponse serverResponse;

        //根据路径生成文件
        String sourceFilePath = sourceFile.getPath();

        if (!sourceFile.exists()) {
            logger.error("文件不存在");
            return ServerResponse.createByErrorMessage("文件" + sourceFile.getPath() + "不存在");
        }

        //原文件所在目录
        String sourceFileDir = sourceFile.getParent();
        //原文件真实格式
        String sourceRealType = VerifyFileTypeUtil.getFileType(sourceFile);
        //如果没有格式，说明文件不是支持的格式
        if (sourceRealType.length() <= 1) {
            logger.error("文件格式不支持 {}", sourceFilePath);
            return ServerResponse.createByErrorMessage("文件" + sourceFile.getName() + "不是支持的文件格式");
        }

        String folder = FileUtil.formatFolder(qrcodeDir);
        //无需转换，直接上传至指定目录
        serverResponse = saveToFtp(sourceFile, sourceFile.getName(), folder);

        return serverResponse;
    }

    /**
     * 将图片文件的宽度和高度信息写入文件记录
     *
     * @param fileHistory 文件对应的文件记录
     * @param imgFile     图片文件
     */
    private void addWidthAndHeight(FileHistory fileHistory, File imgFile) {
        try {
            BufferedImage bufferedImage = ImageIO.read(imgFile);
            fileHistory.addWidthAndHeight(bufferedImage.getWidth(), bufferedImage.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取图片 {} 的宽高异常: {}", imgFile.getPath(), e.getMessage());
        }
    }

    /**
     * 保存文件到指定目录
     *
     * @param fromPath    文件来源路径
     * @param toDir       指定保存目录
     * @param outFileName 保存文件名
     * @return 保存结果
     */
    private ServerResponse saveFile(String fromPath, String toDir, String outFileName) {

        try {
            File fromFile = new File(fromPath);
            FileUtils.copyFile(fromFile, new File(toDir + separator + outFileName));

            return ServerResponse.createBySuccess();
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage(fromPath + "保存至" + toDir + "失败: " + e.getMessage());
        }
    }

    /**
     * 保存文件到指定FTP服务器
     *
     * @param fromPath     文件来源路径
     * @param saveFileName 保存到服务器的文件名
     * @param url          保存到FTP服务器的指定URL
     * @return 保存结果
     */
    private ServerResponse saveToFtp(String fromPath, String saveFileName, String url) {

        File fromFile = new File(fromPath);
        return saveToFtp(fromFile, saveFileName, url);
    }

    /**
     * 保存文件到指定FTP服务器
     *
     * @param fromFile     文件来源路径
     * @param saveFileName 保存到服务器的文件名
     * @param url          保存到FTP服务器的指定URL
     * @return 保存结果
     */
    private ServerResponse saveToFtp(File fromFile, String saveFileName, String url) {

        ServerResponse serverResponse = iFileService.upload(fromFile, saveFileName, url);
        return serverResponse;
    }
}
