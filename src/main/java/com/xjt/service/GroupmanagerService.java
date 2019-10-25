package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GroupmanagerReqDto;

public interface GroupmanagerService {

    /**
     * 添加管理组
     * @param reqDto
     * @return
     */
    BaseResDto insertGroupManager(GroupmanagerReqDto reqDto);

    /**
     * 删除管理组 包括组里的成员
     * @param reqDto
     * @return
     */
    BaseResDto deleteGroupManager(GroupmanagerReqDto reqDto);

    /**
     * 查看所有管理组
     */
    BaseResDto queryGroupList(GroupmanagerReqDto reqDto);
}
