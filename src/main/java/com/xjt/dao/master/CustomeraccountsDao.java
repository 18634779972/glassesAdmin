package com.xjt.dao.master;

import com.xjt.entity.CustomeraccountsKey;

public interface CustomeraccountsDao {
    int deleteByPrimaryKey(CustomeraccountsKey key);

    int insert(CustomeraccountsKey record);

    int insertSelective(CustomeraccountsKey record);
}