package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.dto.GoodsReqDto;
import com.xjt.service.GoodspicturemgtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "货品文件上传")
@RequestMapping("/uploadGoodsFile")
public class GoodspicturemgtController {

    @Value("${project.saveFilePath}")
    private String savePath;
    @Autowired
    private GoodspicturemgtService service;

    @PostMapping("/insertGoodsFileInfo")
    @ApiOperation("货品上传文件接口")
    @ApiImplicitParam(name = "files",value = "上传的文件",required = true)
    public BaseResDto insertGoodsFileInfo(GoodsReqDto reqDto){
        return service.insertGoodsFileInfo(reqDto.getFiles(),savePath,reqDto.getGoodsno());

    }

}
