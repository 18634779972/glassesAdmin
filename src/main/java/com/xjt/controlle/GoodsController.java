package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.annotation.QueryList;
import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsReqDto;
import com.xjt.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(tags = "货品相关接口")
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    private Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Value("${project.saveFilePath}")
    private String savePath;

    @PostMapping("/insertGoods")
    @ApiOperation("添加货品相关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsname",value = "货品名称",required = true),
            @ApiImplicitParam(name = "goodsno",value = "货品编号",required = true),
            @ApiImplicitParam(name = "goodsmanuno",value = "厂家编号",required = true),
            @ApiImplicitParam(name = "files",value = "上传的文件")
    })
    public BaseResDto insertGoods(GoodsReqDto reqDto){
        return goodsService.insertGoods(reqDto,savePath);
    }



    @QueryList
    @GetMapping("/queryGoodsList")
    @ApiOperation("查看货品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页几条",required = true),
            @ApiImplicitParam(name = "categoryid2",value = "二级分类列表",required = true)
    })
    public BaseResDto queryGoodsList(GoodsReqDto reqDto,HttpSession session){
        List<String> brands = (List<String>) session.getAttribute("brandPers");
        List<String> supplys = (List<String>) session.getAttribute("supplyPers");
        logger.info("品牌权限"+JSONObject.toJSONString(brands));
        reqDto.setBrands(brands);
        reqDto.setSupplys(supplys);
        return goodsService.queryGoodsList(reqDto);
    }


    @GetMapping("/queryGoodsInfo")
    @ApiOperation("查看货品详情")
    @ApiImplicitParam(name = "goodsid",value = "货品id",required = true)
    public BaseResDto queryGoodsInfo(GoodsReqDto reqDto){
        return goodsService.queryGoodsInfo(reqDto);
    }


}
