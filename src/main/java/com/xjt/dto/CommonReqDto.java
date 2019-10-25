package com.xjt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel
public class CommonReqDto extends BaseReqDto {

    /**
     * 对应数据库表名
     */
    @ApiModelProperty("对应数据库表名")
    private String tableName;

    /**
     * 对应数据库字段名
     */
    @ApiModelProperty("对应数据库字段名")
    private String colName;

    /**
     * 字段值集合
     */
    @ApiModelProperty("字段值集合")
    private List<String> values;
    /**
     * 单个字段值
     */
    @ApiModelProperty("单个字段值")
    private String value;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
