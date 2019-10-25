package com.xjt.business.impl;

import com.xjt.business.DictbrandBusinessService;
import com.xjt.dao.master.DictbrandDao;
import com.xjt.entity.Dictbrand;
import com.xjt.utils.STRUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DictbrandBusinessServiceImpl implements DictbrandBusinessService {
    @Resource
    private DictbrandDao dictbrandDao;

    /**
     * 添加品牌
     * @param dictbrand
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addBrand(Dictbrand dictbrand) {
        dictbrand.setId(STRUtils.createUUID());
        dictbrand.setDeleteFlag(1L);
        int num = dictbrandDao.insert(dictbrand);
        if(num != 1){
            throw new RuntimeException("添加品牌异常");
        }
    }

    /**
     * 更新品牌有效值
     * @param dictbrand
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateDeleteFlag(Dictbrand dictbrand) {

        int num = dictbrandDao.updateDeleteFlag(dictbrand);
        if(num !=1){
            throw new RuntimeException("更新品牌有效值异常");
        }

    }
}
