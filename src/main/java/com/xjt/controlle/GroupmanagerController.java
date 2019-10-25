package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GroupmanagerReqDto;
import com.xjt.service.GroupmanagerService;
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
@RequestMapping("/groupmanager")
@Api(tags = "管理组/角色相关接口")
public class GroupmanagerController {

    @Autowired
    private GroupmanagerService groupmanagerService;

    /**
     * 添加管理组
     * @param reqDto
     * @return
     */
    @PostMapping("/insertGroupManager")
    @ApiOperation("添加管理组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupName",value = "角色/组名称",required = true),
            @ApiImplicitParam(name = "masterId",value = "创建者id",required = true)
    })
    public BaseResDto insertGroupManager(GroupmanagerReqDto reqDto){
        return groupmanagerService.insertGroupManager(reqDto);
    }

    /**
     * 更改管理组有效信息 包括管理组对应的权限 deleteFlag 0 无效 1 有效
     * 管理组下面有成员 不允许删除
     * @param reqDto
     * @return
     */
    @PostMapping("/updateDeleteFlag")
    @ApiOperation("更改管理组有效信息 包括管理组对应的权限 deleteFlag 0 无效 1 有效 管理组下面有成员 不允许删除")
    @ApiImplicitParam(name = "groupId",value = "组id",required = true)
    public BaseResDto updateDeleteFlag(GroupmanagerReqDto reqDto){
        return groupmanagerService.deleteGroupManager(reqDto);
    }

    /**
     * 查看管理组列表
     * @param reqDto
     * @return
     */
    @GetMapping("/queryGroupList")
    @ApiOperation("查看管理组列表")
    public BaseResDto queryGroupList(GroupmanagerReqDto reqDto){
        return groupmanagerService.queryGroupList(reqDto);
    }
}
