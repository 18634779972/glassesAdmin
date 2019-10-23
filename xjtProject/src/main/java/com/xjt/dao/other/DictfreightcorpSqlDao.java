package com.xjt.dao.other;

import com.xjt.entity.Dictfreightcorp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictfreightcorpSqlDao {

    int deleteByPrimaryKey(String freightcorp);

    int insert(Dictfreightcorp record);

    int insertSelective(Dictfreightcorp record);

    Dictfreightcorp selectByPrimaryKey(String freightcorp);

    int updateByPrimaryKeySelective(Dictfreightcorp record);

    int updateByPrimaryKey(Dictfreightcorp record);

    /**
     * 批量添加公司
     * @param records
     * @return
     */
    int insertBatch(@Param("records") List<Dictfreightcorp> records);

    /**
     * 批量删除公司根据公司名称
     * @param records
     * @return
     */
    int deleteBatch(@Param("records") List<Dictfreightcorp> records);


    List<Dictfreightcorp> queryAllCorps(Dictfreightcorp dictfreightcorp);
}