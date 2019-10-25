package com.xjt.fileupload.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Scott Lau
 * @Date Create in 18/4/27 10:20
 * @Description 文件工具类
 */
public class FileUtil {

    private static final String separator = File.separator;

    /**
     * 将多个MultipartFile转为File
     *
     * @param multipartFiles MultipartFile文件集合
     * @return File文件集合
     */
    public static List<File> createTempFiles(List<MultipartFile> multipartFiles, String dir) throws IOException {
        List<File> files = new ArrayList<>(multipartFiles.size());
        for (MultipartFile itemFile : multipartFiles) {
            File file = createTempFile(itemFile, dir);
            if (file != null) {
                files.add(createTempFile(itemFile, dir));
            }
        }
        return files;
    }

    /**
     * 将单个MultipartFile转为File
     *
     * @param multipartFile MultipartFile文件
     * @return File文件
     */
    public static File createTempFile(MultipartFile multipartFile, String dir) throws IOException {

        if (multipartFile.getSize() <= 0) {
            return null;
        }

        File tmpFile = new File(dir + separator + multipartFile.getOriginalFilename());
        System.out.println(tmpFile.getPath() + "  " + tmpFile.getParent());
        if (!tmpFile.getParentFile().exists()) {
            tmpFile.getParentFile().mkdirs();
        }
        //multipartFile.transferTo(tmpFile);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), tmpFile);
        return tmpFile;
    }

    /**
     * 生成UUID随机文件名
     *
     * @return  返回生成的文件名
     */
    public static String getNewFileName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 格式化文件夹路径
     *
     * @param folder    文件夹名称
     * @return          格式化后的文件夹路径
     */
    public static String formatFolder(String folder) {
        if (StringUtils.isBlank(folder)) {
            return "/";
        }
        /*if (!folder.contains(":") && !folder.startsWith("/")) {
            folder = "/" + folder;
        }
        if (folder.endsWith("/")) {
            folder = folder.substring(0, folder.length() - 1);
        }*/
        return folder;
    }
}
