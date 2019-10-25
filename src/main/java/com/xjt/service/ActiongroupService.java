package com.xjt.service;

import com.xjt.dto.ActiongroupReqDto;
import com.xjt.dto.BaseResDto;

public interface ActiongroupService {

    /**
     * 为组批量添加权限
     * @param reqDto
     * @return
     */
    BaseResDto insertActionForGroupBatch(ActiongroupReqDto reqDto);

    /**
     * 查看组内对应的权限
     * @param groupId
     * @return
     */
    BaseResDto queryActionsByGroupId(String groupId);

    /**
     * 删除组内对应的权限
     * @param reqDto
     * @return
     */
    BaseResDto deleteActionFromGroup(ActiongroupReqDto reqDto);
}
