package com.xjt.dao.master;

import com.xjt.entity.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseDao {
    int deleteByPrimaryKey(String warehouseNo);

    int insert(Warehouse record);

    int insertSelective(Warehouse record);

    Warehouse selectByPrimaryKey(String warehouseNo);

    int updateByPrimaryKeySelective(Warehouse record);

    int updateByPrimaryKey(Warehouse record);

    List<Warehouse> queryHouseList(@Param("ids") List<String> ids);
}