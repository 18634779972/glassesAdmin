package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsbarcodeReqDto;

public interface GoodsbarcodeService {

    /**
     * 添加货品膜层 屈光 散光
     * @param reqDto
     * @return
     */
    BaseResDto insertGoodsbarcode(GoodsbarcodeReqDto reqDto);

    /**
     * 根据货品编号查看信息
     * @param reqDto
     * @return
     */
    BaseResDto queryGoodsbarcodeInfo(GoodsbarcodeReqDto reqDto);
}
