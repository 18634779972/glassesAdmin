package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.BusireportReqDto;

public interface BusireportService {

    BaseResDto insertBusireport(BusireportReqDto reqDto);

    BaseResDto queryBusInfo(BusireportReqDto reqDto);

    BaseResDto updateBusInfo(BusireportReqDto reqDto);
}
