package com.xjt.dto;

import com.xjt.entity.DictBrand;

import java.util.List;

public class DicBrandReqDto {

    private List<DictBrand> brands;

    public List<DictBrand> getBrands() {
        return brands;
    }

    public void setBrands(List<DictBrand> brands) {
        this.brands = brands;
    }
}
