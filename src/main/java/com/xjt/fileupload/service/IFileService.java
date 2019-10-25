package com.xjt.fileupload.service;


import com.xjt.fileupload.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IFileService {

    ServerResponse upload(MultipartFile file, String remoteFileName, String path, String folder);

    ServerResponse upload(File file, String remoteFileName, String folder);

    ServerResponse delete(String folder, String filename);

    ServerResponse<File> download(String folder, String filename);

    ServerResponse<File> downloadPro(String folder, String filename, String rootFolderFile, String projectName, String originFullName);

    /*boolean connectFtpServer();*/
}
