package com.xjt.dao.master;

import com.xjt.entity.Dictbankaccounts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictbankaccountsDao {
    int deleteByPrimaryKey(String id);

    /**
     * 增加开户行信息
     * @param record
     * @return
     */
    int insert(Dictbankaccounts record);

    int insertSelective(Dictbankaccounts record);

    Dictbankaccounts selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dictbankaccounts record);

    int updateByPrimaryKey(Dictbankaccounts record);
}