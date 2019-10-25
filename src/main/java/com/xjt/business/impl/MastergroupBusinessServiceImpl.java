package com.xjt.business.impl;

import com.xjt.business.MastergroupBusinessService;
import com.xjt.dao.master.MastergroupDao;
import com.xjt.dto.MastergroupReqDto;
import com.xjt.entity.Mastergroup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MastergroupBusinessServiceImpl implements MastergroupBusinessService {

    @Resource
    private MastergroupDao mastergroupDao;

    /**
     * 批量添加用户入组
     * @param mastergroups
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertMasterToGroupBatch(List<Mastergroup> mastergroups) {

        int num = mastergroupDao.insertMasterToGroupBatch(mastergroups);
        if(num != mastergroups.size()){
            throw new RuntimeException("批量添加用户入组异常");
        }
    }

    /**
     * 批量更改组里成员有效值
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDeleteFlagBatch(MastergroupReqDto reqDto) {
        int num = mastergroupDao.updateDeleteFlagBatch(reqDto);

        if(num != reqDto.getUserIds().size()){
            throw new RuntimeException("批量更改组里成员有效值异常");
        }
    }
}
