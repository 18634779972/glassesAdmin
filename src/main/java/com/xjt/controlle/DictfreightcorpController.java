package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictfreightcorp;
import com.xjt.service.DictfreightcorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictfreightcorpController {
    @Autowired
    private DictfreightcorpService dictfreightcorpService;

    /**
     * 批量增加数据
     * @param dictfreightcorps
     * @param db
     * @return
     */
    @RequestMapping("/insertBatch")
    public BaseResDto insertBatch(@RequestBody List<Dictfreightcorp> dictfreightcorps, @RequestParam("db") Integer db){
        return dictfreightcorpService.insertBatch(dictfreightcorps,db);
    }

    /**
     * 批量删除数据
     * @param dictfreightcorps
     * @param db
     * @return
     */
    @RequestMapping("/deleteBatch")
    public BaseResDto deleteBatch(@RequestBody List<Dictfreightcorp> dictfreightcorps, @RequestParam("db") Integer db){
        return dictfreightcorpService.deleteBatch(dictfreightcorps,db);
    }

    /**
     * 查看公司
     * @param dictfreightcorp
     * @return
     */
    @RequestMapping("/queryAllCorps")
    public BaseResDto queryAllCorps(Dictfreightcorp dictfreightcorp){
        return dictfreightcorpService.queryAllCorp(dictfreightcorp);
    }
}
