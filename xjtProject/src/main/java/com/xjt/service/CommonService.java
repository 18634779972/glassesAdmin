package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;

public interface CommonService {

    BaseResDto insertDatasBatch(CommonReqDto reqDto);

    BaseResDto deleteDatasBatch(CommonReqDto reqDto);

    BaseResDto queryAllData(CommonReqDto reqDto);
}
