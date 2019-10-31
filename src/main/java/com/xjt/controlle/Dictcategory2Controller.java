package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.entity.Dictcategory2;
import com.xjt.service.Dictcategory2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "二级分类相关接口")
@RequestMapping("/twoCate")
public class Dictcategory2Controller {

    @Autowired
    private Dictcategory2Service dictcategory2Service;



    @PostMapping("/insertTwoCate")
    @ApiOperation("一级分类下批量添加二级分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category2name",value = "二级分类名",required = true),
            @ApiImplicitParam(name = "categoryid",value = "父级分类id",required = true)
    })
    public BaseResDto insertTwoCate(Dictcategory1ReqDto reqDto){

        return dictcategory2Service.insertBatch(reqDto);
    }

    @GetMapping("/queryTwoCateList")
    @ApiOperation("查看二级分类列表")
    @ApiImplicitParam(name = "categoryid",value = "一级分类id",required = true)
    public BaseResDto queryTwoCateList(Dictcategory1ReqDto reqDto){
        return dictcategory2Service.queryTwoCateList(reqDto);
    }


    @PostMapping("/deleteTwoCate")
    @ApiOperation("删除二级分类")
    @ApiImplicitParam(name = "twoCateIds",value = "二级分类id",required = true)
    public BaseResDto deleteTwoCate(Dictcategory1ReqDto reqDto){
        return dictcategory2Service.deleteTwoCate(reqDto);
    }



}
