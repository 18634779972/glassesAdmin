package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;
import com.xjt.service.MasterService;
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
@Api(tags = "用户管理相关接口")
@RequestMapping("/master")
public class MasterController  {

    @Autowired
    private MasterService masterService;

    /**
     * 添加用户信息
     * @param reqDto
     * @return
     */
    @ApiOperation("添加用户信息")
    @PostMapping("/insertMaster")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "用户密码",required = true),
            @ApiImplicitParam(name = "dept",value = "用户部门",required = true)
    })
    public BaseResDto insertMaster(MasterReqDto reqDto){
        return masterService.insertMaster(reqDto);
    }

    /**
     * 更新用户有效状态值（逻辑删除用户）
     * @param reqDto
     * @return
     */
    @PostMapping("/updateDeleteFlagMaster")
    @ApiOperation("更新用户有效状态值（逻辑删除用户）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",required = true),
            @ApiImplicitParam(name = "deleteFlag",value = "是否有效 0 否，1 是")
    })
    public BaseResDto updateDeleteFlag(MasterReqDto reqDto){
        return masterService.deleteMaster(reqDto);
    }

    /**
     * 更新用户
     * @param reqDto
     * @return
     */
    @PostMapping("/updateMaster")
    @ApiOperation("更新用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public BaseResDto updateMaster(MasterReqDto reqDto){
        return masterService.updateMaster(reqDto);
    }

    /**
     * 分页查看用户列表
     * @param reqDto
     * @return
     */
    @GetMapping("/queryMasterList")
    @ApiOperation("分页查看用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数，第几页",required = true),
            @ApiImplicitParam(name = "pageSize",value = "分页参数，每页请求几条",required = true)
    })
    public BaseResDto queryMasterList(MasterReqDto reqDto){
        return masterService.queryMasterList(reqDto);
    }

    /**
     * 查看单个用户信息
     * @param id
     * @return
     */
    @GetMapping("/queryMasterInfo")
    @ApiOperation("查看单个用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public BaseResDto queryMasterInfo(String id ){

        return masterService.queryMasterInfo(id);
    }


}
