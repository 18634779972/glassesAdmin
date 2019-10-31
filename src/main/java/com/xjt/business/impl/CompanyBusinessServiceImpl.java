package com.xjt.business.impl;

import com.xjt.business.CompanyBusinessService;
import com.xjt.dao.master.CompanyDao;
import com.xjt.entity.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CompanyBusinessServiceImpl implements CompanyBusinessService {

    @Resource
    private CompanyDao companyDao;

    /**
     * 添加公司
     * @param company
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertCompany(Company company) {
        int num = companyDao.insert(company);
        if(num != 1){
            throw new RuntimeException("添加公司异常");
        }
    }
}
