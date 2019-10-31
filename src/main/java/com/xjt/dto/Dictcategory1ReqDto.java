package com.xjt.dto;

import java.util.List;

public class Dictcategory1ReqDto extends BaseReqDto {

    /**
     * 分类编号(guid)
     */
    private String categoryid;

    /**
     * 分类名
     */
    private String category;

    /**
     * 系统定义
     */
    private Integer sysdef;

    /**
     * 是否效期管理 1是 0 否
     */
    private Integer isvalidity;

    /**
     * 是否批次管理 1 是 0 否
     */
    private Integer isbatch;

    /**
     * 序号
     */
    private Integer sort;

    /**
     * 二级分类名
     */
    private List<String> category2name;
    /**
     * 二级分类id
     */
    private List<String> twoCateIds;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSysdef() {
        return sysdef;
    }

    public void setSysdef(Integer sysdef) {
        this.sysdef = sysdef;
    }

    public Integer getIsvalidity() {
        return isvalidity;
    }

    public void setIsvalidity(Integer isvalidity) {
        this.isvalidity = isvalidity;
    }

    public Integer getIsbatch() {
        return isbatch;
    }

    public void setIsbatch(Integer isbatch) {
        this.isbatch = isbatch;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<String> getCategory2name() {
        return category2name;
    }

    public void setCategory2name(List<String> category2name) {
        this.category2name = category2name;
    }

    public List<String> getTwoCateIds() {
        return twoCateIds;
    }

    public void setTwoCateIds(List<String> twoCateIds) {
        this.twoCateIds = twoCateIds;
    }
}
