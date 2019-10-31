package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsbarcodeReqDto;
import com.xjt.service.GoodsbarcodeService;
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
@Api(tags = "货品屈光 散光 条码 接口")
@RequestMapping("/goodsbarcode")
public class GoodsbarcodeController {

    @Autowired
    private GoodsbarcodeService goodsbarcodeService;

    @PostMapping("/insertGoodsBarcode")
    @ApiOperation("增加货品相关信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsno",value = "货品编号",required = true),
            @ApiImplicitParam(name = "colordd",value = "颜色膜层",required = true),
            @ApiImplicitParam(name = "barcode",value = "货品条码",required = true),
            @ApiImplicitParam(name = "astigmia",value = "散光度",required = true),
    })
    public BaseResDto insertGoodsBarcode(GoodsbarcodeReqDto reqDto){
        return  goodsbarcodeService.insertGoodsbarcode(reqDto);
    }

    @GetMapping("/queryGoodsBarcodeInfo")
    @ApiOperation("根据货品编号查看货品的膜层屈光散光")
    @ApiImplicitParam(name = "goodsno",value = "货品编号",required = true)
    public BaseResDto queryGoodsBarcodeInfo(GoodsbarcodeReqDto reqDto){
        return goodsbarcodeService.queryGoodsbarcodeInfo(reqDto);
    }
}
