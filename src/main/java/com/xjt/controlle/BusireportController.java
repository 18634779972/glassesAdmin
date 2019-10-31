package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.BusireportReqDto;
import com.xjt.service.BusireportService;
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
@Api(tags = "企业经营许可证相关接口")
@RequestMapping("/busireport")
public class BusireportController {

    @Autowired
    private BusireportService busireportService;

    @PostMapping("/insertBusireport")
    @ApiOperation("添加企业经营许可证信息")
    @ApiImplicitParam(name = "reportType",value = "请求类型 1 经营许可，2 生产许可",required = true)
    public BaseResDto insertBusireport(BusireportReqDto reqDto){
      return  busireportService.insertBusireport(reqDto);
    }


    @GetMapping("/queryBusInfo")
    @ApiOperation("根据 许可证编号 企业名称 法人 查看经营许可证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reportType",value = "请求类型 1 经营许可，2 生产许可",required = true),
            @ApiImplicitParam(name = "permitno",value = "许可证编号"),
            @ApiImplicitParam(name = "enterprisename",value = "企业名称"),
            @ApiImplicitParam(name = "legal",value = "法人")
    })
    public  BaseResDto queryBusInfo(BusireportReqDto reqDto){
        return busireportService.queryBusInfo(reqDto);
    }

    @PostMapping("/updateBusInfo")
    @ApiOperation("更新企业经营许可证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brid",value = "主键id",required = true),
            @ApiImplicitParam(name = "reportType",value = "请求类型 1 经营许可，2 生产许可",required = true)
    })

    public BaseResDto updateBusInfo(BusireportReqDto reqDto){
        return busireportService.updateBusInfo(reqDto);
    }
}
