package com.xjt.service;

import com.xjt.dto.ActioncolumnReqDto;
import com.xjt.dto.BaseResDto;

import java.util.List;

public interface ActioncolumnService {

    /**
     * 添加分栏
     * @param reqDto
     * @return
     */
    BaseResDto insertSubfield (ActioncolumnReqDto reqDto);

    BaseResDto queryColumnList();


}
