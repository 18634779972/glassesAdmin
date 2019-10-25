package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel
public class MastergroupReqDto extends BaseReqDto {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private String id;

    /**
     * 管理员id(关联master表)
     */
    @ApiModelProperty("管理员id")
    private String masterId;

    /**
     * 管理员名称
     */
    @ApiModelProperty("管理员名称")
    private String name;

    /**
     * 管理组id(关联到groupmanager表)
     */
    @ApiModelProperty("管理组id")
    private String groupId;

    /**
     * 修改者id
     */
    @ApiModelProperty("修改者id")
    private String menderId;

    /**
     * 修改者名称
     */
    @ApiModelProperty("修改者名称")
    private String menderName;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date createdate;

    /**
     * 是否有效 0 否 1 有
     */
    @ApiModelProperty("是否有效 0 否 1 有")
    private Long deleteFlag;

    /**
     * 多个用户id
     * @return
     */
    @ApiModelProperty("多个用户id")
    private List<String> userIds;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
