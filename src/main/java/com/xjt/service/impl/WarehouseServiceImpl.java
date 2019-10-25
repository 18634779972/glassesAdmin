package com.xjt.service.impl;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;
import com.xjt.service.WarehouseService;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    /**
     * 增加仓库
     * @param reqDto
     * @return
     */
    @Override
    public BaseResDto insertWareHouse(WarehouseReqDto reqDto) {
        BaseResDto baseResDto = new BaseResDto();
        String houseName = reqDto.getWarehouseNa();
        Boolean tag = reqDto.getTag();

        return null;
    }
}
