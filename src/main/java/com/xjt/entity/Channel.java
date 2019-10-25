package com.xjt.entity;

import java.util.Date;

/**
 * 渠道表
 * 
 * @author wcyong
 * 
 * @date 2019-10-25
 */
public class Channel {
    /**
     * 主键id(关联datapermission表)
     */
    private String id;

    /**
     * 渠道名称
     */
    private String channel;

    /**
     * 渠道地址
     */
    private String channelAddress;

    /**
     * 负责人id
     */
    private String masterId;

    /**
     * 是否删除，0为删除 1为未删除
     */
    private Long deleteFlag;

    /**
     * 创建者id
     */
    private String createId;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getChannelAddress() {
        return channelAddress;
    }

    public void setChannelAddress(String channelAddress) {
        this.channelAddress = channelAddress == null ? null : channelAddress.trim();
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId == null ? null : masterId.trim();
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
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