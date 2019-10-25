package com.xjt.entity;

import java.util.Date;

/**
 * 人员关联表
 * 
 * @author wcyong
 * 
 * @date 2019-10-24
 */
public class Mastergroup {
    /**
     * 主键id
     */
    private String id;

    /**
     * 管理员id(关联master表)
     */
    private String masterId;

    /**
     * 管理员名称
     */
    private String name;

    /**
     * 管理组id(关联到groupmanager表)
     */
    private String groupId;

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
    private Date createdate;

    /**
     * 是否有效 0 否 1 有
     */
    private Long deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getGroupId() {
        return groupId;
    }

    public String getMenderId() {
        return menderId;
    }

    public void setMenderId(String menderId) {
        this.menderId = menderId;
    }

    public String getMenderName() {
        return menderName;
    }

    public void setMenderName(String menderName) {
        this.menderName = menderName == null ? null : menderName.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}