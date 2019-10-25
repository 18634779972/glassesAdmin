package com.xjt.controlle;

import com.alibaba.fastjson.JSONObject;
import com.xjt.dto.BaseResDto;
import com.xjt.entity.Dictcategory2;
import com.xjt.service.Dictcategory2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Dictcategory2Controller {

    @Autowired
    private Dictcategory2Service dictcategory2Service;

    static Logger logger = LoggerFactory.getLogger(Dictcategory2Controller.class);

    /**
     * 批量添加二级分类
     * @param records
     * @param db
     * @return
     */
    @RequestMapping("/insertBatchcate")
    public BaseResDto insertBatch(@RequestBody List<Dictcategory2> records, @RequestParam("db") Integer db){
        return dictcategory2Service.insertBatch(records,db);
    }

    /**
     * 批量删除二级分类 可以全部删除一级分类下的所有 也可以删除单个二级分类
     * @param records
     * @param db
     * @return
     */
    @RequestMapping("/deleteBatchcate")
    public BaseResDto deleteBatch(@RequestBody List<Dictcategory2> records,@RequestParam("db") Integer db){
        return dictcategory2Service.deleteBatch(records,db);
    }

    /**
     * 默认查看一级分类下的所有二级分类
     * @param dictcategory2
     * @return
     */
    @RequestMapping("/queryAllCategory")
    public BaseResDto queryAllCategory(Dictcategory2 dictcategory2){
        return dictcategory2Service.queryAllCategory2(dictcategory2);
    }

    public static void main(String[] args){
        List<Dictcategory2> dictcategory2s = new ArrayList<>();
        dictcategory2s.add(new Dictcategory2("女士卫衣","卫衣"));
        dictcategory2s.add(new Dictcategory2("男士卫衣","卫衣"));
        dictcategory2s.add(new Dictcategory2("男士短裤","短裤"));
        logger.info(JSONObject.toJSONString(dictcategory2s));
    }
}
