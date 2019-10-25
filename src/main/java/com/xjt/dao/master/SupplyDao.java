package com.xjt.dao.master;

import com.xjt.entity.Supply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplyDao {
    int deleteByPrimaryKey(String supplyNo);

    int insert(Supply record);

    int insertSelective(Supply record);

    Supply selectByPrimaryKey(String supplyNo);

    int updateByPrimaryKeySelective(Supply record);

    int updateByPrimaryKey(Supply record);

    List<Supply> querySupplyList(@Param("ids") List<String> ids);
}