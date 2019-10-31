package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsReqDto;

public interface GoodsService {

    /**
     * 添加货品
     * @param reqDto
     * @return
     */
    BaseResDto insertGoods(GoodsReqDto reqDto,String savePath);

    /**
     * 查看货品列表
     * @param reqDto
     * @return
     */
    BaseResDto queryGoodsList(GoodsReqDto reqDto);

    /**
     * 查看货品详情
     * @param reqDto
     * @return
     */
    BaseResDto queryGoodsInfo(GoodsReqDto reqDto);

    /**
     * 根据数据权限查看货品信息
     */
    BaseResDto queryGoodsChoice(GoodsReqDto reqDto);


}
