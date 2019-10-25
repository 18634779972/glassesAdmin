package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GroupmanagerReqDto;
import com.xjt.service.GroupmanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupmanagerController {

    @Autowired
    private GroupmanagerService groupmanagerService;

    /**
     * 添加管理组
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertGroupManager")
    public BaseResDto insertGroupManager(GroupmanagerReqDto reqDto){
        return groupmanagerService.insertGroupManager(reqDto);
    }

    /**
     * 更改管理组有效信息 包括管理组成员 管理组对应的权限 deleteFlag 0 无效 1 有效
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateDeleteFlag")
    public BaseResDto updateDeleteFlag(GroupmanagerReqDto reqDto){
        return groupmanagerService.deleteGroupManager(reqDto);
    }

    /**
     * 查看管理组列表
     * @param reqDto
     * @return
     */
    @RequestMapping("/queryGroupList")
    public BaseResDto queryGroupList(GroupmanagerReqDto reqDto){
        return groupmanagerService.queryGroupList(reqDto);
    }
}
