package com.xjt.utils;

import com.google.api.client.util.Maps;
import com.sun.tools.internal.ws.processor.model.Model;
import com.xjt.fileupload.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    /**
     * 项目批量导入Excel保存
     **/
    @RequestMapping(params = "excelImport")
    @ResponseBody
    public ServerResponse excelImport(Model model, @RequestParam MultipartFile excelFile, String parentId, String proCode, String financialYear) throws Exception {


        if (excelFile != null) {
            String excelName = excelFile.getOriginalFilename();//获得文件名
            String subfixExcel = excelName.substring(excelName.lastIndexOf(".") + 1, excelName.length());//截取点以后的字符
            if (!subfixExcel.equals("xls")) {
                return ServerResponse.createByErrorMessage("文件读取失败，请选择格式为xls的Excel文件");
            }
        }
        if (excelFile != null) {
            for (int i = 0; i < excelFile.getSize(); i++) {
                MultipartFile file = excelFile;
                //保存文件
                //1在项目的根目录临时文件夹下生成一个文件；
//                    String name = file.getOriginalFilename();
//                    System.out.print(name);//控制台输出
                ///2用工具类读取Excel文件中数据接收存放 到List中
                ServerResponse<ArrayList<String[]>> excelDataResult = ProjectFromExcel.generateUserSql(file.getInputStream());//可能有异常

                if (!excelDataResult.isSuccess()) {
                    return excelDataResult;
                }

                ArrayList<String[]> excelData = excelDataResult.getData();

                //定义一个错误的集合，String用来存放错误的信息
                List<String> errorList = new ArrayList<String>();
                //3.将ArrayList<String[]>转换成PO的集合对象，同时完成对数据的校验,
                //如果单元格校验不通过此条记录仍然保存其他正确的字段
              //  List<ProjectEntity> projectList = this.convertExcelPOList(excelData, errorList);

                for(int k= 0,j = excelData.size();k<j;k++){

                }
                //返回json
//                Map<String, Object> result = Maps.newHashMap();
//                //如果有错误跳入提示错误页面，不保存
//                if (errorList != null && errorList.size() > 0) {
//                    //将错误的信息在页面中显示 提示【某行、某列】数据的问题
//                    return ServerResponse.createByErrorMessage(errorList.toString());
//                } else {
//
//
//                    return ServerResponse.createBySuccess("导入成功");
//                }
            }
        }
        return ServerResponse.createByErrorMessage("Excel文件读取失败");
    }
}
