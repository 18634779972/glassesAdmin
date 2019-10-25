package com.xjt.service;

import com.xjt.dto.ActionReqDto;
import com.xjt.dto.BaseResDto;

public interface ActionService {

    /**
     * 添加权限
     * @param reqDto
     * @return
     */
    BaseResDto insertAction(ActionReqDto reqDto);

    /**
     * 删除权限
     * @param reqDto
     * @return
     */
    BaseResDto deleteAction(ActionReqDto reqDto);

    /**\
     * 更新权限信息
     * @param reqDto
     * @return
     */
    BaseResDto updateAction(ActionReqDto reqDto);

    /**
     * 查看分栏下的权限
     * @param cloumnId
     * @return
     */
    BaseResDto queryActionsByCloumn(String cloumnId);
}
