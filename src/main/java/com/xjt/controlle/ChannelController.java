package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.ChannelReqDto;
import com.xjt.service.ChannelService;
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
@Api(tags = "渠道相关接口")
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    /**
     * 增加渠道
     * @param reqDto
     * @return
     */
    @PostMapping("/insertChannel")
    @ApiOperation("增加渠道")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "channel",value = "渠道名称",required = true),
            @ApiImplicitParam(name = "masterId",value = "负责人id",required = true),
            @ApiImplicitParam(name = "createId",value = "创建者id",required = true)
    })
    public BaseResDto insertChannel(ChannelReqDto reqDto){
        return channelService.insertChannel(reqDto);
    }

    /**
     * 更新渠道有效值 deleteFlag 1 有效 0 无效
     * @param reqDto
     * @return
     */
    @PostMapping("/updateChannelFlag")
    @ApiOperation("更新渠道有效值 deleteFlag 1 有效 0 无效")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "渠道id",required = true),
            @ApiImplicitParam(name = "deleteFlag",value = "是否有效 0 否 1 是",required = true)
    })
    public BaseResDto updateDeleteFlag(ChannelReqDto reqDto){
        return channelService.updateDeleteFlag(reqDto);
    }

    /**
     * 更新渠道有效值
     * @param reqDto
     * @return
     */
    @PostMapping("/updateChannelInfo")
    @ApiOperation("更新渠道有效值")
    @ApiImplicitParam(name = "id",value = "渠道id",required = true)
    public BaseResDto updateChannelInfo(ChannelReqDto reqDto){
        return channelService.updateChannelInfo(reqDto);
    }

    /**
     * 查看渠道列表，可以分页查看
     * @param reqDto
     * @return
     */
    @GetMapping("/queryChannelList")
    @ApiOperation("查看渠道列表，可以分页查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo",value = "分页参数，第几页"),
            @ApiImplicitParam(name = "pageSize",value = "分页参数 每页数据量")
    })
    public BaseResDto queryChannelList(ChannelReqDto reqDto){
        return channelService.queryChannelList(reqDto);
    }

    /**
     * 查看渠道详情
     * @param reqDto
     * @return
     */
    @GetMapping("/queryChannelInfo")
    @ApiOperation("查看渠道详情")
    @ApiImplicitParam(name = "id",value = "渠道id",required = true)
    public BaseResDto queryChannelInfo(ChannelReqDto reqDto){
        return channelService.queryChannelInfo(reqDto);
    }
}
