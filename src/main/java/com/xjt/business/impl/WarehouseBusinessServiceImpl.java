package com.xjt.business.impl;

import com.xjt.business.WarehouseBusinessService;
import com.xjt.dao.master.WarehouseDao;
import com.xjt.entity.Warehouse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class WarehouseBusinessServiceImpl implements WarehouseBusinessService {

    @Resource
    private WarehouseDao warehouseDao;

    /**
     * 增加仓库
     * @param warehouse
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertWarehouse(Warehouse warehouse) {
        int num = warehouseDao.insert(warehouse);
        if(num !=1){
            throw new RuntimeException("增加仓库异常");
        }

    }
}
