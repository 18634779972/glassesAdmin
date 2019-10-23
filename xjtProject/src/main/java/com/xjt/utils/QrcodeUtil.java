package com.xjt.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.xjt.fileupload.common.FileConst;
import com.xjt.fileupload.common.ServerResponse;
import com.xjt.fileupload.operation.FileOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码工具类
 */
public class QrcodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(QrcodeUtil.class);

    private static FileOperation fileOperation;
    //下面2个属性需要在appConfig.properties属性文件中根据实际情况进行配置
    public static String DIR = BranchPropUtil.loadAppConfig("qrcode_dir");//存放目录
    public static String QRCODE_URL = BranchPropUtil.loadAppConfig("qrcode_url");//访问路径

    static {
        fileOperation = (FileOperation) ApplicationContextUtil.getContext().getBean(FileOperation.class);
    }

    /**
     * 返回二维码图片访问路径，在之后拼接上图片名称即可。
     * @return
     */
    public static String getQrcodeAccessUrlPrefix(){
        //return FileConst.ftpAccessUrl + FileConst.baseDir +  FileConst.qrcodeDir + "/";
        return FileConst.qrcodePreviewMethod;
    }


    /**
     * 创建URL的二维码图片。如果已存在，则不再创建（如果isForceCreate为true，则即使存在，也会重新创建）
     * @param url ： URL链接内容
     * @param fileName ： 生成的文件名，不包括后缀。比如传入12345,会生成12345.png。 <br>
     *                 <b>约定：必须传入经过统一编码的值，以保证惟一性。</b>
     * @param isForceCreate true:即使图片已经存在，也会重新生成; false:如果存在，则不再重新生成。
     * @param isUploadToFtp 是否上传至FTP服务器？ 如果为false（系统初始化时使用），则不上传至FTP服务器.如果为true，则上传至FTP服务器
     * @param width 宽度 像素
     * @param height  高度 像素
     * @return 二维码访问url
     * @throws WriterException
     * @throws IOException
     */
    public static String encode(String url,String fileName,boolean isForceCreate,boolean isUploadToFtp,int width,int height) throws WriterException, IOException {
        //String filePath = "D://";
        //String fileName = "zxing.png";
        //String content = "http://www.iteye.com/";
        String format = "png";// 图像类型
        fileName = fileName+"."+format;
        String pathname = DIR+fileName;
        //int width = 200; // 图像宽度
        //int height = 200; // 图像高度
        File file = new File(pathname);
        if(isForceCreate || !file.exists()){//或强制生成，或文件不存在时，生成图片
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url,BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
            MatrixToImageWriter.writeToFile(bitMatrix, format, file);// 输出图像
            file = new File(pathname);
            if(isUploadToFtp){//是否上传至ftp
                //  System.out.println("#####################################....");
                ServerResponse serverResponse = fileOperation.saveQrcode(file);
                //System.out.println("   serverResponse.isSuccess=="+serverResponse.isSuccess());
                if(!serverResponse.isSuccess()){
                    logger.error("二维码生成后，上传FPT服务器时失败。文件名：["+pathname+"]。错误信息："+serverResponse.getMsg());
                }
            }

        }
        //String fullpath = QRCODE_URL+fileName;
        String fullpath = getQrcodeAccessUrlPrefix()+fileName;
        //System.out.println("###################### fullpath="+fullpath );
        return fullpath;
    }

    /**
     * 创建URL的二维码图片。如果已存在，则不再创建（如果isForceCreate为true，则即使存在，也会重新创建）<br>
     * 图片默认大小;200x200
     * @param url ： URL链接内容
     * @param fileName ： 生成的文件名，不包括后缀。比如传入12345,会生成12345.png。 <br>
     *                 <b>约定：必须传入经过统一编码的值，以保证惟一性。</b>
     * @param isForceCreate  true:即使图片已经存在，也会重新生成; false:如果存在，则不再重新生成。
     * @return 二维码访问url
     * @throws WriterException
     * @throws IOException
     */
    public static String encode(String url,String fileName,boolean isForceCreate) throws WriterException, IOException {
        return encode(url,fileName,isForceCreate,true,200,200);
    }

    /**
     * 创建URL的二维码图片。如果已存在，则不再创建（如果isForceCreate为true，则即使存在，也会重新创建）<br>
     * 图片默认大小;200x200
     * @param url ： URL链接内容
     * @param fileName ： 生成的文件名，不包括后缀。比如传入12345,会生成12345.png。 <br>
     *                 <b>约定：必须传入经过统一编码的值，以保证惟一性。</b>
     * @param isForceCreate  true:即使图片已经存在，也会重新生成; false:如果存在，则不再重新生成。
     * @param isUploadToFtp 是否上传至FTP服务器？ 如果为false（系统初始化时使用），则不上传至FTP服务器.如果为true，则上传至FTP服务器
     * @return 二维码访问url
     * @throws WriterException
     * @throws IOException
     */
    public static String encode(String url,String fileName,boolean isForceCreate,boolean isUploadToFtp) throws WriterException, IOException {
        return encode(url,fileName,isForceCreate,isUploadToFtp,200,200);
    }

    /**
     * 创建URL的二维码图片。如果已存在，则不再创建<br>
     * 图片默认大小;200x200；<br>
     * 默认行为：如果图片已经存在，不再生成。
     * @param url ： URL链接内容
     * @param fileName ： 生成的文件名，不包括后缀。比如传入12345,会生成12345.png。 <br>
     *                 <b>约定：必须传入经过统一编码的值，以保证惟一性。</b>
     * @return 二维码访问url
     * @throws WriterException
     * @throws IOException
     */
    public static String encode(String url,String fileName) throws WriterException, IOException {
        return encode(url,fileName, false);
    }
}
