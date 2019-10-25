package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.CommonReqDto;
import com.xjt.service.CommonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "单字段表相关操作接口")
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    /**
     * 批量添加数据
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertDatasBatch")
    public BaseResDto insertDatasBatch(CommonReqDto reqDto){
        return commonService.insertDatasBatch(reqDto);
    }

    /**
     * 批量删除数据
     * @param reqDto
     * @return
     */
    @RequestMapping("/deleteDatasBatch")
    public BaseResDto deleteDatasBatch(CommonReqDto reqDto){
        return commonService.deleteDatasBatch(reqDto);
    }

    /**
     * 查看所有数据
     */
    @RequestMapping("/queryAllDatas")
    public BaseResDto queryAllDatas(CommonReqDto reqDto){
        return commonService.queryAllData(reqDto);
    }
}
