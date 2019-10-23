package com.xjt.fileupload.util;


import com.xjt.fileupload.common.ServerResponse;
import com.xjt.utils.StringUtils;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinioUtil {

    private static final Logger logger = LoggerFactory.getLogger(MinioUtil.class);

    private final String DEFAULT_DIR = "default";
    private final String TPM_DIR = System.getProperty("java.io.tmpdir");

    private final String endpoint = PropertyUtil.getPropertyByName("minio.properties", "minio.endpoint");
    private final String accessKey = PropertyUtil.getPropertyByName("minio.properties", "minio.accesskey");
    private final String secretKey = PropertyUtil.getPropertyByName("minio.properties", "minio.secretkey");

    public static MinioUtil getInstance() {
        return new MinioUtil();
    }

    /**
     * 获取Minio客户端
     *
     * @return Minio客户端
     */
    private MinioClient getMinioClient() {
        try {
            return new MinioClient(endpoint, accessKey, secretKey);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件URL
     *
     * @param folder   文件夹
     * @param filename 文件名
     * @return URL
     */
    public String getFileUrl(String folder, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            return minioClient.presignedGetObject(folder, filename);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件URL(可访问时间限制)
     *
     * @param folder   文件夹
     * @param filename 文件名
     * @param expires  可访问时间(秒)
     * @return URL
     */
    public String getFileUrl(String folder, String filename, Integer expires) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            return minioClient.presignedGetObject(folder, filename, expires);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件
     *
     * @param folder   文件夹
     * @param filename 文件名
     * @return 文件流
     */
    public InputStream getFileInputStream(String folder, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            return minioClient.getObject(folder, filename);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 获取文件
     *
     * @param folder   文件夹
     * @param filename 文件名
     * @return 文件流
     */
    public ServerResponse<File> getFile(String folder, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        File localFile = new File(TPM_DIR + File.separator + filename);

        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(localFile);
            inputStream = minioClient.getObject(folder, filename);
            if (inputStream == null) {
                return ServerResponse.createByErrorMessage("文件不存在");
            }

            int ch;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
                outputStream.flush();
            }
            outputStream.close();
            inputStream.close();
            return ServerResponse.createBySuccess(localFile);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }

    /**
     * 获取指定文件夹下的全部文件名
     *
     * @param folder 文件夹
     * @return 文件名列表
     */
    public List<String> getFiles(String folder) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            Iterable<Result<Item>> objects = minioClient.listObjects(folder);
            List<String> filenames = new LinkedList<>();
            for (Result<Item> object : objects) {
                Item item = object.get();
                filenames.add(item.objectName());
            }
            return filenames;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 保存文件
     *
     * @param folder 文件夹
     * @param file   文件
     * @return 保存结果
     */
    public ServerResponse saveMultipartFile(String folder, MultipartFile file) {
        folder = formatFolder(folder);
        return saveMultipartFile(folder, file, file.getOriginalFilename());
    }

    /**
     * 保存文件
     *
     * @param folder   文件夹
     * @param file     文件
     * @param filename 保存的文件名
     * @return 保存结果
     */
    public ServerResponse saveMultipartFile(String folder, MultipartFile file, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            if (!minioClient.bucketExists(folder)) {
                minioClient.makeBucket(folder);
            }
            minioClient.putObject(folder, filename, file.getInputStream(), file.getSize(), file.getContentType());
            return ServerResponse.createBySuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }

    /**
     * 批量保存文件
     *
     * @param folder    文件夹
     * @param files     文件列表
     * @param filenames 保存的文件名列表
     * @return 保存结果
     */
    public ServerResponse saveMultipartFiles(String folder, List<MultipartFile> files, List<String> filenames) {
        folder = formatFolder(folder);
        for (int i = 0; i < files.size(); i++) {
            if (!saveMultipartFile(folder, files.get(i), filenames.get(i)).isSuccess()) {
                return ServerResponse.createByErrorMessage("保存失败");
            }
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 批量保存文件
     *
     * @param folder 文件夹
     * @param files  文件列表
     * @return 保存结果
     */
    public ServerResponse saveMultipartFiles(String folder, List<MultipartFile> files) {
        folder = formatFolder(folder);
        for (MultipartFile file : files) {
            if (!saveMultipartFile(folder, file, file.getOriginalFilename()).isSuccess()) {
                return ServerResponse.createByErrorMessage("保存失败");
            }
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 保存文件
     *
     * @param folder 文件夹
     * @param file   文件
     * @return 保存结果
     */
    public ServerResponse saveFile(String folder, File file) {
        folder = formatFolder(folder);
        return saveFile(folder, file, file.getName());
    }

    /**
     * 保存文件
     *
     * @param folder   文件夹
     * @param file     文件
     * @param filename 保存的文件名
     * @return 保存结果
     */
    public ServerResponse saveFile(String folder, File file, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        if (file == null || !file.exists()) {
            return ServerResponse.createByError();
        }

        try {
            if (!minioClient.bucketExists(folder)) {
                minioClient.makeBucket(folder);
            }
            InputStream fileInputStream = new FileInputStream(file);
            minioClient.putObject(folder, filename, fileInputStream,
                    file.length(), Files.probeContentType(Paths.get(file.getPath())));
            return ServerResponse.createBySuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }

    /**
     * 批量保存文件
     *
     * @param folder    文件夹
     * @param files     文件列表
     * @param filenames 保存的文件名列表
     * @return 保存结果
     */
    public ServerResponse<Object> saveFiles(String folder, List<File> files, List<String> filenames) {
        folder = formatFolder(folder);
        for (int i = 0; i < files.size(); i++) {
            if (!saveFile(folder, files.get(i), filenames.get(i)).isSuccess()) {
                return ServerResponse.createByErrorMessage("保存失败");
            }
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 批量保存文件
     *
     * @param folder 文件夹
     * @param files  文件列表
     * @return 保存结果
     */
    public ServerResponse saveFiles(String folder, List<File> files) {
        folder = formatFolder(folder);
        for (File file : files) {
            if (!saveFile(folder, file, file.getName()).isSuccess()) {
                return ServerResponse.createByErrorMessage("保存失败");
            }
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 删除文件
     *
     * @param folder   所在文件夹
     * @param filename 文件名
     */
    public ServerResponse deleteFile(String folder, String filename) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        try {
            minioClient.removeObject(folder, filename);
            return ServerResponse.createBySuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("删除失败");
        }
    }

    /**
     * 处理文件夹名
     *
     * @param folder 文件夹
     * @return
     */
    private String formatFolder(String folder) {
        if (StringUtils.isBlank(folder) || StringUtils.equals(folder, "/")) {
            return DEFAULT_DIR;
        }
        return folder;
    }

    public ServerResponse<File> getProFile(String folder, String filename, String rootFolderFile, String projectName, String originFullName) {
        folder = formatFolder(folder);
        MinioClient minioClient = getMinioClient();
        File localFile = new File(TPM_DIR + File.separator + rootFolderFile + File.separator + projectName + File.separator + originFullName);
        if (!localFile.getParentFile().exists()) {
            localFile.getParentFile().mkdirs();
        }

        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(localFile);
            inputStream = minioClient.getObject(folder, filename);
            if (inputStream == null) {
                return ServerResponse.createByErrorMessage("文件不存在");
            }

            int ch;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
                outputStream.flush();
            }
            outputStream.close();
            inputStream.close();
            return ServerResponse.createBySuccess(localFile);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("保存失败");
        }
    }
}
