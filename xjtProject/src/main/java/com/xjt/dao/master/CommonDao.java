package com.xjt.dao.master;

import com.xjt.dto.CommonReqDto;
import com.xjt.entity.CommonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonDao {

    /**
     * 批量增加 单字段
     * @param tableName
     * @param values
     * @return
     */
    int insertBatch(@Param("tableName") String tableName,@Param("values") List<String> values);


    /**
     * 批量删除 单字段
     * @param tableName
     * @param colName
     * @param values
     * @return
     */
    int deleteBatch(@Param("tableName") String tableName,@Param("colName") String colName,@Param("values") List<String> values);

    /**
     * 公共查看
     * @param reqDto
     * @return
     */
    List<CommonData> queryAllDatas(CommonReqDto reqDto);
}
