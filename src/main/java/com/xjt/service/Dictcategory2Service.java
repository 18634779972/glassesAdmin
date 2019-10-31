package com.xjt.service;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory2;

import java.util.List;

public interface Dictcategory2Service {

    /**
     * 一级分类下添加二级分类
     * @param reqDto
     * @return
     */
    BaseResDto insertBatch(Dictcategory1ReqDto reqDto);

    /**
     * 查看二级分类列表
     * @param reqDto
     * @return
     */
    BaseResDto queryTwoCateList(Dictcategory1ReqDto reqDto);

    /**
     * 删除一级分类下的二级分类
     * @param reqDto
     * @return
     */
    BaseResDto deleteTwoCate(Dictcategory1ReqDto reqDto);


}
