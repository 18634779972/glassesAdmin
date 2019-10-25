package com.xjt.entity;

import java.util.Date;

/**
 * 品牌表
 * 
 * @author wcyong
 * 
 * @date 2019-10-25
 */
public class Dictbrand {
    /**
     * 主键id(关联datapermission表)
     */
    private String id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 是否删除，0为删除 1为未删除
     */
    private Long deleteFlag;

    /**
     * 创建者id
     */
    private String masterId;

    /**
     * 创建者名称
     */
    private String masterName;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 修改者id
     */
    private String menderId;

    /**
     * 修改者名称
     */
    private String menderName;

    /**
     * 修改时间
     */
    private Date updatedate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName == null ? null : masterName.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getMenderId() {
        return menderId;
    }

    public void setMenderId(String menderId) {
        this.menderId = menderId == null ? null : menderId.trim();
    }

    public String getMenderName() {
        return menderName;
    }

    public void setMenderName(String menderName) {
        this.menderName = menderName == null ? null : menderName.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}