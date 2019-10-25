package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MastergroupReqDto;
import com.xjt.service.MastergroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MastergroupController {

    @Autowired
    private MastergroupService mastergroupService;


    /**
     * 批量添加用户入组
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertMasterToGroupBatch")
    public BaseResDto insertMasterToGroupBatch(MastergroupReqDto reqDto){
        return mastergroupService.insertMasterToGroupBatch(reqDto);
    }

    /**
     * 批量 更改组里用户有效值
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateDeleteFlagBatch")
    public BaseResDto updateDeleteFlagBatch(MastergroupReqDto reqDto){
        return mastergroupService.updateDeleteFlagBatch(reqDto);
    }


    /**
     * 查看组里的用户信息
     * @param reqDto
     * @return
     */
    @RequestMapping("/queryMasterInfoOfGroup")
    public BaseResDto queryMasterInfoOfGroup(MastergroupReqDto reqDto){
        return mastergroupService.queryMasterInfoOfGroup(reqDto);
    }

}
