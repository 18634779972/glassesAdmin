package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.SupplyReqDto;
import com.xjt.service.SupplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "供货商相关接口")
public class SupplyController {

    @Autowired
    private SupplyService supplyService;

    @PostMapping("/insertSupply")
    @ApiOperation("增加供货商")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "supplyNa",value = "供货商全称",required = true),
            @ApiImplicitParam(name = "registernumber",value = "供货商营业执照号",required = true),
            @ApiImplicitParam(name = "keyMan",value = "负责人",required = true),
            @ApiImplicitParam(name = "registerDateStr",value = "注册日期 格式：yyyy-MM-dd",required = true),
            @ApiImplicitParam(name = "expriDateStr",value = "到期日期 格式：yyyy-MM-dd",required = true)
    })
    public BaseResDto insertSupply(SupplyReqDto reqDto){
        return supplyService.insertSupply(reqDto);
    }

    @GetMapping("/querySupplyList")
    @ApiOperation("供货商列表 可以分页查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页"),
            @ApiImplicitParam(name = "pageSize",value = "分页参数，每页几条")
    })
    public BaseResDto querySupplyList(SupplyReqDto reqDto){
        return supplyService.querySupplyList(reqDto);
    }

    @GetMapping("/querySupplyInfo")
    @ApiOperation("查看供货商详情")
    @ApiImplicitParam(name = "supplyNo",value = "供货商编号",required = true)
    public BaseResDto querySupplyInfo(SupplyReqDto reqDto){
        return supplyService.querySupplyInfo(reqDto);
    }
}
