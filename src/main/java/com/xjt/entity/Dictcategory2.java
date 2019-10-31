package com.xjt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-10-30
 */
public class Dictcategory2 {
    /**
     * 分类编号(Guid)
     */
    private String categoryid;

    /**
     * 分类名
     */
    private String category;

    /**
     * 上级分类编号
     */
    private String parentcategory;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid == null ? null : categoryid.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getParentcategory() {
        return parentcategory;
    }

    public void setParentcategory(String parentcategory) {
        this.parentcategory = parentcategory == null ? null : parentcategory.trim();
    }
}