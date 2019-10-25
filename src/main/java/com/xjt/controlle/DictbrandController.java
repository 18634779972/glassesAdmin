package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.DictbrandReqDto;
import com.xjt.service.DictbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictbrandController {

    @Autowired
    private DictbrandService dictbrandService;

    /**
     * 添加品牌
     * @param reqDto
     * @return
     */
    @RequestMapping("/addBrand")
    public BaseResDto addBrand(DictbrandReqDto reqDto){
        return dictbrandService.addBrand(reqDto);
    }

    /**
     * 更改品牌有效值
     * @param reqDto
     * @return
     */
    @RequestMapping("/updateBrandFlag")
    public BaseResDto updateDeleteFlag(DictbrandReqDto reqDto){
        return dictbrandService.updateDeleteFlag(reqDto);
    }

    /**
     * 查看品牌列表
     * @param reqDto
     * @return
     */
    @RequestMapping("/queryBrandList")
    public BaseResDto queryBrandList(DictbrandReqDto reqDto){
        return dictbrandService.queryBrandList(reqDto);
    }

    /**
     * 查看品牌信息
     * @param reqDto
     * @return
     */
    @RequestMapping("/queryBrandInfo")
    public BaseResDto queryBrandInfo(DictbrandReqDto reqDto){
        return dictbrandService.queryBrandInfo(reqDto);
    }
}
