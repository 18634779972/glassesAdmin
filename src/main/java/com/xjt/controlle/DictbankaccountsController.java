package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbankaccountsReqDto;
import com.xjt.service.DictbankaccountsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "开户行相关接口")
@RequestMapping("/bank")
public class DictbankaccountsController {
    @Autowired
    private DictbankaccountsService dictbankaccountsService;

    @PostMapping("/insertBankInfo")
    @ApiOperation("增加开户行信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bank",value = "开户行名称",required = true),
            @ApiImplicitParam(name = "bankaddr",value = "开户行地址",required = true),
            @ApiImplicitParam(name = "accountname",value = "户名",required = true),
            @ApiImplicitParam(name = "accounts",value = "行号",required = true)
    })
    public BaseResDto insertBankInfo(DictbankaccountsReqDto reqDto){
        return dictbankaccountsService.insertBankInfo(reqDto);
    }
}
