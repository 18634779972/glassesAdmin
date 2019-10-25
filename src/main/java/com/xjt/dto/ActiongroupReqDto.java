package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel
public class ActiongroupReqDto extends BaseReqDto {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private String id;

    /**
     * 动作名称(与action表关联)
     */
    @ApiModelProperty("动作名称")
    private String action;

    /**
     * 动作所属组id(关联到mastergroup表)
     */
    @ApiModelProperty("动作所属组id")
    private String groupId;

    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private String masterId;

    /**
     * 创建者名称
     */
    @ApiModelProperty("创建者名称")
    private String masterName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdate;

    /**
     * 是否有效 0 否 1 是
     */
    @ApiModelProperty("是否有效 0 否 1 是")
    private Long deleteFlag;

    private List<String> actionIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
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

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<String> getActionIds() {
        return actionIds;
    }

    public void setActionIds(List<String> actionIds) {
        this.actionIds = actionIds;
    }
}
