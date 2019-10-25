package com.xjt.controlle;

import com.xjt.dto.ActionReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action")
@Api(tags = "操作权限相关接口")
public class ActionController {

    @Autowired
    private ActionService actionService;

    /**
     * 添加权限
     * @param reqDto
     * @return
     */
    @PostMapping("/insertAction")
    @ApiOperation("添加权限")
    @ApiImplicitParam(name = "actionName",value = "权限名称",required = true)
    public BaseResDto insertAction(ActionReqDto reqDto){
        return actionService.insertAction(reqDto);
    }

    /**
     * 更改权限有效值 deleteFlag 0 无效 1 有效
     * @param reqDto
     * @return
     */
    @PostMapping("/updateDeleteFlagAction")
    @ApiOperation("更改权限有效值 deleteFlag 0 无效 1 有效")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "actionid",value = "权限id",required = true),
            @ApiImplicitParam(name = "deleteFlag",value = "deleteFlag 0 无效 1 有效",required = true)
    })
    public BaseResDto updateDeleteFlag(ActionReqDto reqDto){
        return actionService.deleteAction(reqDto);
    }

    /**
     * 更新权限信息 挪动权限分栏 更改是否可见...
     * @param reqDto
     * @return
     */
    @PostMapping("/updateActionInfo")
    @ApiOperation("更新权限信息 挪动权限分栏 更改是否可见...")
    @ApiImplicitParam(name ="actionid",value = "权限id",required = true)
    public BaseResDto updateActionInfo(ActionReqDto reqDto){
        return actionService.updateAction(reqDto);
    }

    /**
     * 查看分栏下的权限
     */
    @GetMapping("/queryActionsByCloumn")
    @ApiOperation("查看分栏下的权限")
    @ApiImplicitParam(name = "cloumnId",value = "分栏id",required = true)
    public BaseResDto queryActionsByCloumn(String cloumnId){
        return actionService.queryActionsByCloumn(cloumnId);
    }
}
