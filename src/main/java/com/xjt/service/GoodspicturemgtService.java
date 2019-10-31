package com.xjt.service;

import com.xjt.dto.BaseResDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodspicturemgtService {

    BaseResDto insertGoodsFileInfo(List<MultipartFile> files,String savePath,String goodsId);
}
