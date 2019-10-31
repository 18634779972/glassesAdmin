package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DatapermissionReqDto;

public interface DatapermissionService {

    /**
     * 管理组添加数据权限
     * @param reqDto
     * @return
     */
    BaseResDto addDataPermissionForGroup(DatapermissionReqDto reqDto);

    /**
     * 更改管理组数据权限
     * @param reqDto
     * @return
     */
    BaseResDto updatePermissionForGroup(DatapermissionReqDto reqDto);

    /**
     * 查看管理组品牌权限
     */
    BaseResDto queryBrandPermission(DatapermissionReqDto reqDto);

    /**
     * 查看管理组渠道权限
     * @param reqDto
     * @return
     */
    BaseResDto queryCustomerPermission(DatapermissionReqDto reqDto);


    /**
     * 查看管理组仓库权限
     */
    BaseResDto queryWareHousePermission(DatapermissionReqDto reqDto);

    /**
     * 查看管理组供货商权限
     */
    BaseResDto querySupplyPermission(DatapermissionReqDto reqDto);



}
