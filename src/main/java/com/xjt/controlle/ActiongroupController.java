package com.xjt.controlle;

import com.xjt.dto.ActiongroupReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActiongroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ActiongroupController {
    @Autowired
    private ActiongroupService actiongroupService;

    /**
     * 为组批量添加权限
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertActionForGroupBatch")
    public BaseResDto insertActionForGroupBatch(ActiongroupReqDto reqDto){

        return actiongroupService.insertActionForGroupBatch(reqDto);
    }

    /**
     * 查看组内的权限
     * @param groupId
     * @return
     */
    @RequestMapping("/queryActionsByGroupId")
    public BaseResDto queryActionsByGroupId(String groupId){
        return actiongroupService.queryActionsByGroupId(groupId);
    }

    /**
     * 删除组内对应的权限 批量删除  actionIds groupId
     * @param reqDto
     * @return
     */
    @RequestMapping("/deleteActionFromGroup")
    public BaseResDto deleteActionFromGroup(ActiongroupReqDto reqDto){
        return actiongroupService.deleteActionFromGroup(reqDto);
    }
}
