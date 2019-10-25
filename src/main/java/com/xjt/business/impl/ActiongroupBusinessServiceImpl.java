package com.xjt.business.impl;

import com.xjt.business.ActiongroupBusinessService;
import com.xjt.dao.master.ActiongroupDao;
import com.xjt.dto.ActiongroupReqDto;
import com.xjt.entity.Actiongroup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ActiongroupBusinessServiceImpl implements ActiongroupBusinessService {

    @Resource
    private ActiongroupDao actiongroupDao;

    /**
     * 为组批量添加权限
     * @param actiongroups
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertActionForGroupBatch(List<Actiongroup> actiongroups) {
        int num = actiongroupDao.insertActionForGroupBatch(actiongroups);
        if(num != actiongroups.size()){
            throw new RuntimeException("为组批量添加权限异常");
        }
    }

    /**
     * 删除组内对应的权限
     * @param reqDto
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteActionFromGroup(ActiongroupReqDto reqDto) {
        int num =actiongroupDao.deleteActionFromGroup(reqDto);

        if(num !=reqDto.getActionIds().size()){
            throw new RuntimeException("批量删除组内对应的权限异常");
        }
    }
}
