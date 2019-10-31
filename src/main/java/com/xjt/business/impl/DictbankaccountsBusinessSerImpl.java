package com.xjt.business.impl;

import com.xjt.business.DictbankaccountsBusinessSer;
import com.xjt.dao.master.DictbankaccountsDao;
import com.xjt.entity.Dictbankaccounts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DictbankaccountsBusinessSerImpl implements DictbankaccountsBusinessSer {

    @Resource
    private DictbankaccountsDao dictbankaccountsDao;

    /**
     * 添加开户行信息
     * @param dictbankaccounts
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertBankInfo(Dictbankaccounts dictbankaccounts) {
        int num = dictbankaccountsDao.insert(dictbankaccounts);
        if(num !=1){
            throw new RuntimeException("添加开户行信息异常");
        }

    }
}
