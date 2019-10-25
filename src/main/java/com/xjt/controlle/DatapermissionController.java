package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DatapermissionReqDto;
import com.xjt.service.DatapermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatapermissionController {

    @Autowired
    private DatapermissionService datapermissionService;

    /**
     * 管理组添加数据权限
     * @param reqDto
     * @return
     */
    @RequestMapping("/addDataPermissionForGroup")
    public BaseResDto addDataPermissionForGroup(DatapermissionReqDto reqDto){
        return datapermissionService.addDataPermissionForGroup(reqDto);
    }

    /**
     * 更新管理组数据权限
     * @param reqDto
     * @return
     */
    @RequestMapping("/updatePermissionForGroup")
    public BaseResDto updatePermissionForGroup(DatapermissionReqDto reqDto){
        return datapermissionService.updatePermissionForGroup(reqDto);
    }

    /**
     * 查看管理组对应的各项权限
     * @param reqDto requestType 1 :品牌，2：渠道，3：供货商， 4：仓库
     * @return
     */
    @RequestMapping("/queryGroupPermission")
    public BaseResDto queryGroupPermission(DatapermissionReqDto reqDto){
        Integer type = reqDto.getRequestType();
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
