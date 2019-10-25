package com.xjt.fileupload.common;


import com.xjt.fileupload.util.PropertyUtil;

/**
 * @Author Scott Lau
 * @Date Create in 18/5/8 11:45
 * @Description
 */
public class FileConst {
    public static final String baseDir = "/filepreview";
    public static final String qrcodeDir = "project-qrcode";

    public static final String tmpFolder = PropertyUtil.getPropertyByName("ftp.properties", "filetmp");

    public static final String ftpAccessUrl = PropertyUtil.getPropertyByName("ftp.properties", "ftp.access-url");
    public static final String ip = PropertyUtil.getPropertyByName("ftp.properties", "ftp.ip");
    public static final int port = Integer.parseInt(PropertyUtil.getPropertyByName("ftp.properties", "ftp.port"));
    public static final String username = PropertyUtil.getPropertyByName("ftp.properties", "ftp.username");
    public static final String password = PropertyUtil.getPropertyByName("ftp.properties", "ftp.password");

    public static final String qrcodePreviewMethod = "/filehistoryController.do?show_qrcode&projectCode";

    //public static String qrcodeDir = PropertyUtil.getPropertyByName("ftp.properties", "qrcodedir");
}
