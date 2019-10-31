package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.Dictcategory1ReqDto;
import com.xjt.service.Dictcategory1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "一级分类相关接口")
@RequestMapping("/oneCate")
public class Dictcategory1Controller {

    @Autowired
    private Dictcategory1Service dictcategory1Service;

    @PostMapping("/insertOneCate")
    @ApiOperation("添加一级分类")
    @ApiImplicitParam(name = "category",value = "一级分类名",required = true)
    public BaseResDto insertOneCate(Dictcategory1ReqDto reqDto){
        return dictcategory1Service.insertOneCategory(reqDto);
    }

    @GetMapping("/queryCateList")
    @ApiOperation("查看一级分类列表")
    public BaseResDto queryCateList(Dictcategory1ReqDto reqDto){
        return dictcategory1Service.queryCateList(reqDto);
    }

    @GetMapping("/queryOneCateInfo")
    @ApiOperation("查看分类详细信息")
    @ApiImplicitParam(name = "categroyid",value = "一级分类id",required = true)
    public BaseResDto queryOneCateInfo(String categroyid){
        return dictcategory1Service.queryOneCateInfo(categroyid);
    }
}
