package com.xjt.controlle;

import com.xjt.dto.ActioncolumnReqDto;
import com.xjt.dto.BaseResDto;
import com.xjt.service.ActioncolumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActioncolumnController {

    @Autowired
    private ActioncolumnService actioncolumnService;

    /**
     * 添加分栏
     * @param reqDto
     * @return
     */
    @RequestMapping("/insertSubfield")
    public BaseResDto insertSubfield(ActioncolumnReqDto reqDto){
        return actioncolumnService.insertSubfield(reqDto);
    }

    /**
     * 查看分栏列表
     */
    @RequestMapping("/queryColumnList")
    public BaseResDto queryColumnList(){
        return actioncolumnService.queryColumnList();
    }
}
