package com.xjt.controlle;

import com.xjt.dto.BaseResDto;
import com.xjt.service.SupplyfilemgtService;
import com.xjt.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api("供货商文件相关接口")
public class SupplyfilemgtController {

    @Autowired
    private SupplyfilemgtService supplyfilemgtService;

    @Value("${project.saveFilePath}")
    private String saveFilePath;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/fileUpload")
    @ApiOperation("文件上传 文件信息入库")
    @ApiImplicitParam(name = "file",value = "上传的文件",required = true)
    public BaseResDto fileUpload(@RequestParam("file") MultipartFile file){

        return supplyfilemgtService.insertFileInfo(file,saveFilePath);
    }
}
