package com.xjt.business;

import com.xjt.dto.MastergroupReqDto;
import com.xjt.entity.Mastergroup;

import java.util.List;

public interface MastergroupBusinessService {

    /**
     * 批量添加成员入组
     * @param mastergroups
     */
    void insertMasterToGroupBatch(List<Mastergroup> mastergroups);

    /**
     * 批量更改组里成员有效值
     */
    void updateDeleteFlagBatch(MastergroupReqDto reqDto);
}
