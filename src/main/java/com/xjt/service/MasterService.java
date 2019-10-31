package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;

public interface MasterService {

    /**
     * 添加用户
     */
    BaseResDto insertMaster(MasterReqDto reqDto);

    /**
     * 删除用户
     */
    BaseResDto deleteMaster(MasterReqDto reqDto);

    /**
     * 更改用户信息
     */
    BaseResDto updateMaster(MasterReqDto reqDto);

    /**
     * 分页查看用户信息
     */
    BaseResDto queryMasterList(MasterReqDto reqDto);

    /**
     * 查看单个用户信息
     */
    BaseResDto queryMasterInfo(String id);

    /**
     * 处理用户登录
     */
    BaseResDto userLoginResolve(MasterReqDto reqDto);

}
