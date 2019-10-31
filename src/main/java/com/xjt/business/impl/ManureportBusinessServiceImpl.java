package com.xjt.business.impl;

import com.xjt.business.ManureportBusinessService;
import com.xjt.dao.master.ManureportDao;
import com.xjt.entity.Manureport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ManureportBusinessServiceImpl implements ManureportBusinessService {
    @Resource
    private ManureportDao manureportDao;

    /**
     * 添加生产企业许可信息
     * @param manureport
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertManureport(Manureport manureport) {
        int num = manureportDao.insert(manureport);
        if(num != 1){
            throw new RuntimeException("添加生产企业许可信息异常");
        }
    }

    /**
     * 更新生产企业许可证信息
     * @param manureport
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateManureport(Manureport manureport) {
        int num = manureportDao.updateByPrimaryKeySelective(manureport);
        if(num !=1){
            throw new RuntimeException("更细生产企业许可证信息异常");
        }

    }
}
