package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MastergroupReqDto;

public interface MastergroupService {

    /**
     * 批量添加用户入组
     * @param reqDto
     * @return
     */
    BaseResDto insertMasterToGroupBatch(MastergroupReqDto reqDto);

    /**
     * 批量更改组里成员有效值
     * @param reqDto
     * @return
     */
    BaseResDto updateDeleteFlagBatch(MastergroupReqDto reqDto);

    /**
     * 分页查看组里用户信息
     */
    BaseResDto queryMasterInfoOfGroup(MastergroupReqDto reqDto);
}
