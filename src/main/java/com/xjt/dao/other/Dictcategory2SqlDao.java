package com.xjt.dao.other;

import com.xjt.entity.Dictcategory2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Dictcategory2SqlDao {
    int deleteByPrimaryKey(String category2);

    int insert(Dictcategory2 record);

    int insertSelective(Dictcategory2 record);

    Dictcategory2 selectByPrimaryKey(String category2);

    int updateByPrimaryKeySelective(Dictcategory2 record);

    int updateByPrimaryKey(Dictcategory2 record);

    /**
     * 批量增加二级分类
     */
    int  insertBatch(@Param("records") List<Dictcategory2> records);

    /**
     * 批量删除
     */
    int deleteBatch(@Param("records") List<Dictcategory2> records);

    List<Dictcategory2> queryCategory2(Dictcategory2 dictcategory2);

}