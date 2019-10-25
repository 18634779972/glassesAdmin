package com.xjt.controlle;

import com.xjt.dto.ActionReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActionService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionController {

    @Autowired
    private ActionService actionService;

    /**
     * 添加权限
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertAction")
    public BaseResDto insertAction(ActionReqDto reqDto){
        return actionService.insertAction(reqDto);
    }

    /**
     * 更改权限有效值
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateDeleteFlagAction")
    public BaseResDto updateDeleteFlag(ActionReqDto reqDto){
        return actionService.deleteAction(reqDto);
    }

    /**
     * 更新权限信息 挪动权限分栏 更改是否可见...
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateActionInfo")
    public BaseResDto updateActionInfo(ActionReqDto reqDto){
        return actionService.updateAction(reqDto);
    }

    /**
     * 查看分栏下的权限
     */
    @RequestMapping("/queryActionsByCloumn")
    public BaseResDto queryActionsByCloumn(String cloumnId){
        return actionService.queryActionsByCloumn(cloumnId);
    }
}
