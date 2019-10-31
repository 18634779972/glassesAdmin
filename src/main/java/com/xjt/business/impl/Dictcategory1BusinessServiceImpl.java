package com.xjt.business.impl;

import com.xjt.business.Dictcategory1BusinessService;
import com.xjt.dao.master.Dictcategory1Dao;
import com.xjt.entity.Dictcategory1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class Dictcategory1BusinessServiceImpl implements Dictcategory1BusinessService {

    @Resource
    private Dictcategory1Dao dictcategory1Dao;

    /**
     * 增加一级分类
     * @param dictcategory1
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertOneCategory(Dictcategory1 dictcategory1) {

        int num = dictcategory1Dao.insert(dictcategory1);
        if(num !=1){
            throw new RuntimeException("增加一级分类异常");
        }
    }
}
