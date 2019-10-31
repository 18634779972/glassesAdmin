package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CompanyReqDto;
import com.xjt.service.CompanyService;
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
@Api(tags = "公司相关接口")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/insertCompany")
    @ApiOperation("增加公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyNa",value = "公司名称",required = true),
            @ApiImplicitParam(name = "keyman",value = "公司负责人",required = true),
            @ApiImplicitParam(name = "address",value = "公司地址",required = true),
            @ApiImplicitParam(name = "tel",value = "公司电话",required = true)
    })
    public BaseResDto insertCompany(CompanyReqDto reqDto){
        return companyService.insertCompany(reqDto);
    }


    @GetMapping("/queryCompanyList")
    @ApiOperation("查看公司列表 ")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页数据量",required = true)
    })
    public BaseResDto queryCompanyList(CompanyReqDto reqDto){
        return companyService.queryCompanyList(reqDto);
    }

    @GetMapping("/queryCompanyInfo")
    @ApiOperation("查看公司信息")
    @ApiImplicitParam(name = "companyId",value = "公司编号",required = true)
    public BaseResDto queryCompanyInfo(CompanyReqDto reqDto){
        return companyService.queryCompanyInfo(reqDto);
    }

}
