package com.xjt.dto;

public class ActioncolumnReqDto extends BaseReqDto {

    /**
     * 主键id
     */
    private String actionColumnId;

    /**
     * 动作名称
     */
    private String actionColumnName;

    /**
     * 是否有效 0  否  1 有
     */
    private Long deleteFlag;

    public String getActionColumnId() {
        return actionColumnId;
    }

    public void setActionColumnId(String actionColumnId) {
        this.actionColumnId = actionColumnId;
    }

    public String getActionColumnName() {
        return actionColumnName;
    }

    public void setActionColumnName(String actionColumnName) {
        this.actionColumnName = actionColumnName == null ? null : actionColumnName.trim();
    }

    public Long getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Long deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
