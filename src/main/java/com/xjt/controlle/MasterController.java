package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.MasterReqDto;
import com.xjt.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController  {

    @Autowired
    private MasterService masterService;

    /**
     * 添加用户信息
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertMaster")
    public BaseResDto insertMaster(MasterReqDto reqDto){
        return masterService.insertMaster(reqDto);
    }

    /**
     * 更新用户有效状态值（逻辑删除用户）
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateDeleteFlagMaster")
    public BaseResDto updateDeleteFlag(MasterReqDto reqDto){
        return masterService.deleteMaster(reqDto);
    }

    /**
     * 更新用户
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateMaster")
    public BaseResDto updateMaster(MasterReqDto reqDto){
        return masterService.updateMaster(reqDto);
    }

    /**
     * 分页查看用户列表
     * @param reqDto
     * @return
     */
    @RequestMapping("/queryMasterList")
    public BaseResDto queryMasterList(MasterReqDto reqDto){
        return masterService.queryMasterList(reqDto);
    }

    /**
     * 查看单个用户信息
     * @param id
     * @return
     */
    @RequestMapping("/queryMasterInfo")
    public BaseResDto queryMasterInfo(String id ){

        return masterService.queryMasterInfo(id);
    }
}
