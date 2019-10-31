package com.xjt.business.impl;

import com.xjt.business.SupplyBusinessService;
import com.xjt.dao.master.SupplyDao;
import com.xjt.entity.Supply;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SupplyBusinessServiceImpl implements SupplyBusinessService {


    @Resource
    private SupplyDao supplyDao;

    /**
     * 增加供货商
     * @param supply
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertSupply(Supply supply) {
         int  num = supplyDao.insert(supply);
         if(num !=1){
             throw new RuntimeException("增加供货商异常");
         }
    }
}
