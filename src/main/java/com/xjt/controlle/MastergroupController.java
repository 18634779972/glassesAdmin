package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MastergroupReqDto;
import com.xjt.service.MastergroupService;
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
@Api(tags = "用户和组关系相关接口")
@RequestMapping("/mastergroup")
public class MastergroupController {

    @Autowired
    private MastergroupService mastergroupService;


    /**
     * 批量添加用户入组
     * @param reqDto
     * @return
     */
    @PostMapping("/insertMasterToGroupBatch")
    @ApiOperation("批量添加用户入组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",value = "组id",required = true),
            @ApiImplicitParam(name = "menderId",value = "创建者id",required = true),
            @ApiImplicitParam(name = "userIds",value = "所选用户id,至少有一个")
    })
    public BaseResDto insertMasterToGroupBatch(MastergroupReqDto reqDto){
        return mastergroupService.insertMasterToGroupBatch(reqDto);
    }

    /**
     * 批量 更改组里用户有效值
     * @param reqDto
     * @return
     */
    @PostMapping("/updateDeleteFlagBatch")
    @ApiOperation("批量 更改组里用户有效值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",value = "组id",required = true),
            @ApiImplicitParam(name = "userIds",value = "所选用户id,至少有一个"),
            @ApiImplicitParam(name = "deleteFlag",value = "是否有效 0 否 1 是",required = true)
    })
    public BaseResDto updateDeleteFlagBatch(MastergroupReqDto reqDto){
        return mastergroupService.updateDeleteFlagBatch(reqDto);
    }


    /**
     * 查看组里的用户信息
     * @param reqDto
     * @return
     */
    @GetMapping("/queryMasterInfoOfGroup")
    @ApiOperation("查看组里的用户信息,如需分页查看 添加分页参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "groupId",value = "组id",required = true),
            @ApiImplicitParam(name = "pageNo",value = "分页参数 第几页"),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页请求数据量")
    })
    public BaseResDto queryMasterInfoOfGroup(MastergroupReqDto reqDto){
        return mastergroupService.queryMasterInfoOfGroup(reqDto);
    }

}
