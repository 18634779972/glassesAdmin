package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.SupplyReqDto;

public interface SupplyService {

    BaseResDto insertSupply(SupplyReqDto reqDto);

    BaseResDto querySupplyList(SupplyReqDto reqDto);

    BaseResDto querySupplyInfo(SupplyReqDto reqDto);
}
