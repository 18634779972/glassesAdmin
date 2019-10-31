package com.xjt.business.impl;

import com.xjt.business.BusireportBusinessService;
import com.xjt.dao.master.BusireportDao;
import com.xjt.entity.Busireport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BusireportBusinessServiceImpl implements BusireportBusinessService {

    @Resource
    private BusireportDao busireportDao;

    /**
     * 增加经营企业许可信息
     * @param busireport
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBusireport(Busireport busireport) {

        int num = busireportDao.insert(busireport);
        if(num !=1){
            throw new RuntimeException("增加经营企业许可信息异常");
        }
    }

    /**
     * 更新经营企业许可信息
     * @param busireport
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateBusireport(Busireport busireport) {
        int num = busireportDao.updateByPrimaryKeySelective(busireport);
        if(num !=1){
            throw new RuntimeException("更新经营企业许可信息异常");
        }
    }
}
