package com.xjt.controlle;

import com.xjt.dto.ActiongroupReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActiongroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "权限和组对应关系相关接口")
@RequestMapping("/actiongroup")
public class ActiongroupController {
    @Autowired
    private ActiongroupService actiongroupService;

    /**
     * 为组批量添加权限
     * @param reqDto
     * @return
     */
    @PostMapping("/insertActionForGroupBatch")
    @ApiOperation("为组批量添加权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",value = "组id",required = true),
            @ApiImplicitParam(name = "masterId",value = "创建者id",required = true),
            @ApiImplicitParam(name = "actionIds",value = "选择的权限id，至少有一个")
    })
    public BaseResDto insertActionForGroupBatch(ActiongroupReqDto reqDto){

        return actiongroupService.insertActionForGroupBatch(reqDto);
    }

    /**
     * 查看组内的权限
     * @param groupId
     * @return
     */
    @GetMapping("/queryActionsByGroupId")
    @ApiOperation("查看组内的权限")
    @ApiImplicitParam(name = "groupId",value = "组/角色id",required = true)
    public BaseResDto queryActionsByGroupId(String groupId){
        return actiongroupService.queryActionsByGroupId(groupId);
    }

    /**
     * 删除组内对应的权限 批量删除  actionIds groupId
     * @param reqDto
     * @return
     */
    @PostMapping("/deleteActionFromGroup")
    @ApiOperation("删除组内对应的权限 可以批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",value = "组/角色id",required = true),
            @ApiImplicitParam(name = "actionIds",value = "选择的权限id，至少有一个")
    })
    public BaseResDto deleteActionFromGroup(ActiongroupReqDto reqDto){
        return actiongroupService.deleteActionFromGroup(reqDto);
    }
}
