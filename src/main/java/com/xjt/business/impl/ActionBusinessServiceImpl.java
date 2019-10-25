package com.xjt.business.impl;

import com.xjt.business.ActionBusinessService;
import com.xjt.dao.master.ActionDao;
import com.xjt.entity.Action;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ActionBusinessServiceImpl implements ActionBusinessService {

    @Resource
    private ActionDao actionDao;

    /**
     * 添加权限
     * @param action
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertAction(Action action) {
        int num = actionDao.insert(action);
        if(num != 1){
            throw new RuntimeException("添加权限异常");
        }
    }

    /**
     * 更改单个权限有效值
     * @param action
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteAction(Action action) {
        int num = actionDao.updateDeleteFlag(action);
        if(num != 1){
            throw new RuntimeException("更改权限有效值异常");
        }
    }
}
