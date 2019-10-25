package com.xjt.business;

import com.xjt.dto.GroupmanagerReqDto;

public interface GroupmanagerBusinessService {

    void insertGroupManager(GroupmanagerReqDto reqDto);

    /**
     * 删除管理组 包括组里成员
     * @param reqDto
     */
    void deleteGroupManager(GroupmanagerReqDto reqDto);
}
