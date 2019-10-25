package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbrandReqDto;

public interface DictbrandService {

    /**
     * 添加品牌
     * @param reqDto
     * @return
     */
    BaseResDto addBrand(DictbrandReqDto reqDto);

    /**
     * 更改品牌有效值
     * @param reqDto
     * @return
     */
    BaseResDto updateDeleteFlag(DictbrandReqDto reqDto);

    /**
     * 查看品牌列表
     * @param reqDto
     * @return
     */
    BaseResDto queryBrandList(DictbrandReqDto reqDto);

    /**
     * 查看品牌详情
     * @param reqDto
     * @return
     */
    BaseResDto queryBrandInfo(DictbrandReqDto reqDto);
}
