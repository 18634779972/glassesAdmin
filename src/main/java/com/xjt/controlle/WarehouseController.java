package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.WarehouseReqDto;
import com.xjt.service.WarehouseService;
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
@Api(tags ="仓库相关接口" )
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/insertWareHouse")
    @ApiOperation("增加仓库接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "warehouseNa",value = "仓库名称",required = true),
            @ApiImplicitParam(name = "address",value = "仓库地址",required = true),
            @ApiImplicitParam(name = "zipcode",value = "仓库电话",required = true),
            @ApiImplicitParam(name = "keyman",value = "负责人",required = true),
            @ApiImplicitParam(name = "tag",value ="是否虚拟仓库 true or false",required = true)
    })
    public BaseResDto insertWareHouse(WarehouseReqDto reqDto){
        return warehouseService.insertWareHouse(reqDto);
    }

    @GetMapping("/queryWarehouseList")
    @ApiOperation("查看仓库列表 可以分页查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页"),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页数据量")
    })
    public BaseResDto queryWarehouseList(WarehouseReqDto reqDto){
        return warehouseService.queryWarehouseList(reqDto);
    }

    @GetMapping("/queryWareInfo")
    @ApiOperation("查看仓库详细信息")
    @ApiImplicitParam(name = "warehouseNo",value = "仓库编号",required = true)
    public BaseResDto queryWareInfo(WarehouseReqDto reqDto){
        return warehouseService.queryHouseInfo(reqDto);
    }
}
