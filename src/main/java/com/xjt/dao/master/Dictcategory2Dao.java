package com.xjt.dao.master;

import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Dictcategory2Dao {

    int deleteByPrimaryKey(String categoryid);

    int insert(Dictcategory2 record);

    int insertSelective(Dictcategory2 record);

    Dictcategory2 selectByPrimaryKey(String categoryid);

    int updateByPrimaryKeySelective(Dictcategory2 record);

    int updateByPrimaryKey(Dictcategory2 record);

    /**
     * 批量添加二级分类
     * @param dictcategory2s
     * @return
     */
    int insertCategory2(@Param("dictcategory2s") List<Dictcategory2> dictcategory2s);

    /**
     * 查看一级分类下的二级分类
     * @param parentCate
     * @return
     */
    List<Dictcategory2> queryByParent(@Param("parentCate") String parentCate);

    /**
     * 删除一级分类下的二级分类
     * @param reqDto
     * @return
     */
    int deleteTwoCate(Dictcategory1ReqDto reqDto);
}