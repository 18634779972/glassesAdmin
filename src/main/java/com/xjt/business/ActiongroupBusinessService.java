package com.xjt.business;

import com.xjt.dto.ActiongroupReqDto;
import com.xjt.entity.Actiongroup;

import java.util.List;

public interface ActiongroupBusinessService {

    /**
     * 添加组内权限
     * @param actiongroups
     */
    void insertActionForGroupBatch(List<Actiongroup> actiongroups);

    /**
     * 删除组内对应的权限
     * @param reqDto
     */
    void deleteActionFromGroup(ActiongroupReqDto reqDto);
}
