package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DatapermissionReqDto;
import com.xjt.enums.ResultCode;
import com.xjt.service.DatapermissionService;
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
@Api(tags = "数据权限相关操作接口")
@RequestMapping("/datapermission")
public class DatapermissionController {

    @Autowired
    private DatapermissionService datapermissionService;

    /**
     * 管理组添加数据权限
     * @param reqDto
     * @return
     */
    @PostMapping("/addDataPermissionForGroup")
    @ApiOperation("管理组添加数据权限")
   @ApiImplicitParam(name = "groupmanagerId",value = "管理组id",required = true)
    public BaseResDto addDataPermissionForGroup(DatapermissionReqDto reqDto){
        return datapermissionService.addDataPermissionForGroup(reqDto);
    }

    /**
     * 更新管理组数据权限
     * @param reqDto
     * @return
     */
    @PostMapping("/updatePermissionForGroup")
    @ApiOperation("更新管理组数据权限")
    @ApiImplicitParam(name = "groupmanagerId",value = "管理组id",required = true)
    public BaseResDto updatePermissionForGroup(DatapermissionReqDto reqDto){
        return datapermissionService.updatePermissionForGroup(reqDto);
    }

    /**
     * 查看管理组对应的各项权限
     * @param reqDto requestType 1 :品牌，2：渠道，3：供货商， 4：仓库
     * @return
     */
    @GetMapping("/queryGroupPermission")
    @ApiOperation("查看管理组对应的各项权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupmanagerId",value = "管理组id",required = true),
            @ApiImplicitParam(name = "requestType",value = "请求类型：requestType 1 :品牌，2：渠道，3：供货商， 4：仓库",required = true)
    })
    public BaseResDto queryGroupPermission(DatapermissionReqDto reqDto){
        Integer type = reqDto.getRequestType();
        BaseResDto baseResDto = new BaseResDto();
        if (type==null||type<1||type>4){
            baseResDto.setResultMessage("输入正确的requestType");
            baseResDto.setResultCode(ResultCode.RESULT_CODE_EXCEPTION.getCode());
            return baseResDto;
        }
        if(type==1){
            return datapermissionService.queryBrandPermission(reqDto);
        }
        if(type==2){
            return  datapermissionService.queryChannelPermission(reqDto);
        }
        if(type==3){
            return datapermissionService.querySupplyPermission(reqDto);
        }
        if(type==4){
            return datapermissionService.queryWareHousePermission(reqDto);
        }
        return null;
    }
}
