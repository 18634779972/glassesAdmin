package com.xjt.dao.master;

import com.xjt.entity.Actioncolumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActioncolumnDao {
    int deleteByPrimaryKey(Long actionColumnId);

    /**
     * 添加分栏
     * @param record
     * @return
     */
    int insert(Actioncolumn record);

    int insertSelective(Actioncolumn record);

    Actioncolumn selectByPrimaryKey(Long actionColumnId);

    int updateByPrimaryKeySelective(Actioncolumn record);

    int updateByPrimaryKey(Actioncolumn record);

    /**
     * 查看分栏列表
     * @return
     */
    List<Actioncolumn> queryActioncolumnList();


}