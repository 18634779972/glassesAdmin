package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 货品名称
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictgoodsname extends BaseReqDto {
    /**
     * 货品名称
     */
    private String goodsname;

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }
}