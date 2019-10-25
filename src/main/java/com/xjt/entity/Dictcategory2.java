package com.xjt.entity;

import com.xjt.dto.BaseReqDto;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-18
 */
public class Dictcategory2 extends BaseReqDto {
    /**
     * 分类1
     */
    private String category2;

    /**
     * 上级分类
     */
    private String parentcategory;

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2 == null ? null : category2.trim();
    }

    public String getParentcategory() {
        return parentcategory;
    }

    public void setParentcategory(String parentcategory) {
        this.parentcategory = parentcategory == null ? null : parentcategory.trim();
    }

    public Dictcategory2(){

    }

    public Dictcategory2(String category2, String parentcategory) {
        this.category2 = category2;
        this.parentcategory = parentcategory;
    }
}