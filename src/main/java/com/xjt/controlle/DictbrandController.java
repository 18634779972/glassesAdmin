package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbrandReqDto;
import com.xjt.service.DictbrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "品牌相关接口")
@RequestMapping("/brand")
public class DictbrandController {

    @Autowired
    private DictbrandService dictbrandService;

    /**
     * 添加品牌
     * @param reqDto
     * @return
     */
    @PostMapping("/addBrand")
    @ApiOperation("添加品牌")
    @ApiImplicitParam(name = "brandName",value = "品牌名称",required = true)
    public BaseResDto addBrand(DictbrandReqDto reqDto){
        return dictbrandService.addBrand(reqDto);
    }

    /**
     * 更改品牌有效值
     * @param reqDto
     * @return
     */
    @PostMapping("/updateBrandFlag")
    @ApiOperation("更新品牌有效状态值（逻辑删除品牌）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "品牌id",required = true),
            @ApiImplicitParam(name = "deleteFlag",value = "是否有效 0 否，1 是")
    })
    public BaseResDto updateDeleteFlag(DictbrandReqDto reqDto){
        return dictbrandService.updateDeleteFlag(reqDto);
    }

    /**
     * 查看品牌列表
     * @param reqDto
     * @return
     */
    @GetMapping("/queryBrandList")
    @ApiOperation("查看品牌列表")
    public BaseResDto queryBrandList(DictbrandReqDto reqDto){
        return dictbrandService.queryBrandList(reqDto);
    }

    /**
     * 查看品牌信息
     * @param reqDto
     * @return
     */
    @GetMapping("/queryBrandInfo")
    @ApiOperation("查看品牌信息")
    @ApiImplicitParam(name = "id",value = "品牌id",required = true)
    public BaseResDto queryBrandInfo(DictbrandReqDto reqDto){
        return dictbrandService.queryBrandInfo(reqDto);
    }
}
