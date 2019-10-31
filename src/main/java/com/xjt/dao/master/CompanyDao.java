package com.xjt.dao.master;

import com.xjt.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDao {
    int deleteByPrimaryKey(String companyId);

    /**
     * 添加公司
     * @param record
     * @return
     */
    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    /**
     * 查看公司列表
     * @return
     */
    List<Company> queryCompanyList();
}