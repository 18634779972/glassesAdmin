package com.xjt.dao.master;

import com.xjt.entity.Dictcategory1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Dictcategory1Dao {
    int deleteByPrimaryKey(String categoryid);

    /**
     * 增加一级分类
     * @param record
     * @return
     */
    int insert(Dictcategory1 record);

    int insertSelective(Dictcategory1 record);

    Dictcategory1 selectByPrimaryKey(String categoryid);

    int updateByPrimaryKeySelective(Dictcategory1 record);

    int updateByPrimaryKey(Dictcategory1 record);

    List<Dictcategory1> queryCateList();
}