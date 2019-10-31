package com.xjt.service;

import com.xjt.dto.BaseResDto;
import org.springframework.web.multipart.MultipartFile;

public interface SupplyfilemgtService {

    BaseResDto insertFileInfo(MultipartFile file,String filePath);
}
