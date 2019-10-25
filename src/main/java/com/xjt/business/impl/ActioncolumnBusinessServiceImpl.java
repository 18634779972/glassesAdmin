package com.xjt.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.xjt.business.ActioncolumnBusinessService;
import com.xjt.dao.master.ActioncolumnDao;
import com.xjt.entity.Actioncolumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ActioncolumnBusinessServiceImpl implements ActioncolumnBusinessService {

    @Resource
    private ActioncolumnDao actioncolumnDao;
    private Logger logger = LoggerFactory.getLogger(ActioncolumnBusinessServiceImpl.class);

    /**
     * 添加分栏
     * @param actioncolumn
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertSubfield(Actioncolumn actioncolumn) {
        actioncolumn.setDeleteFlag(1L);
        logger.info("添加的对象"+JSONObject.toJSONString(actioncolumn));
        int num = actioncolumnDao.insert(actioncolumn);
        if (num != 1){
            throw new RuntimeException("添加分栏异常");
        }
    }
}
