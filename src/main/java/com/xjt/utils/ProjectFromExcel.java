package com.xjt.utils;


import com.xjt.fileupload.common.ServerResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by hs on 2017-06-17.
 */
public class ProjectFromExcel {

    private static final Logger logger = LoggerFactory.getLogger(ProjectFromExcel.class);

    //标准模板表头
    private static final String[] STANDRAD_TITLE = {"序号", "项目年度", "项目名称", "项目类别", "项目状态",
            "实施主体", "建设详细地址", "建设性质", "实施开始年月", "实施完结年月", "覆盖贫困村", "绩效目标",
            "项目建设规模及内容", "受益非贫困户", "受益非贫困人口", "受益贫困户", "受益贫困人口","预计贫困人口增收", "项目负责人", "联系方式", "社会效益", "经济效益",
            "本次拟申请资金","钱物是否直接补助到人","资金申请起始年","资金申请结束年","是否脱贫攻坚项目","预算单位","是否公示","贷款银行","自由资金"};
    //标准模板表头所在行索引
//    private static final int[] STANDRAD_TITLE_ROW_INDEX = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static final int[] STANDRAD_TITLE_ROW_INDEX ={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

    private static final int STANDRAD_TITLE_CELL_COUNT = STANDRAD_TITLE.length;

    public static ServerResponse<ArrayList<String[]>> generateUserSql(InputStream excelFileInputStream)
            throws Exception {

        if (excelFileInputStream == null) {
            throw new Exception("没有文件导入");
        }

        //不支持2007以上版本
        //通过输入流使内存获得Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);

        //获取第一张工作表
        HSSFSheet sheet = workbook.getSheetAt(0);

        //获取第一行表头
        HSSFRow titleRow = sheet.getRow(0);
        if (titleRow == null) {
            return ServerResponse.createByErrorMessage("导入的表格没有表头。请在右上角下载标准模板导入!");
        }

        //获取表头字符串数组
        String[] titleValues = new String[STANDRAD_TITLE_CELL_COUNT];
        for (int i = 0; i < STANDRAD_TITLE_CELL_COUNT; i++) {
            HSSFCell currentCell = sheet.getRow(STANDRAD_TITLE_ROW_INDEX[i]).getCell(i);
            if (currentCell != null) {
                currentCell.setCellType(Cell.CELL_TYPE_STRING);
                titleValues[i] = currentCell.getStringCellValue();
            } else {
                titleValues[i] = "";
            }
        }

        logger.info("title list: " + Arrays.toString(titleValues));

        //与标准模板中表头对比，如有不同则记录下并返回错误信息
        List<Integer> titleErrMsg = new ArrayList<>(STANDRAD_TITLE_CELL_COUNT);
        for (int i = 0; i < STANDRAD_TITLE_CELL_COUNT; i++) {
            if (!STANDRAD_TITLE[i].equals(titleValues[i])) {
                titleErrMsg.add(i + 1);
            }
        }
        if (titleErrMsg.size() > 0) {
            String titleErrMsgStr = titleErrMsg.toString().replace(", ", "、");
            return ServerResponse.createByErrorMessage("第" + titleErrMsgStr
                    + "列表头与标准模板中不匹配");
        }

        //返回的结果集
        ArrayList<String[]> dataList = new ArrayList<>();

        //从excel的第二行开始读数据内容
        int realRowNum = getNotBlankRows(sheet);
        for (int currentRowIndex = 2; currentRowIndex <= realRowNum; currentRowIndex++) {//循环每个工作表中的各行row
            HSSFRow currentRow = sheet.getRow(currentRowIndex);
            String[] rowDatas = new String[STANDRAD_TITLE_CELL_COUNT];//准备接受存放一行row中各cell的值

            if (currentRow != null) {

                for (int currentCellIndex = 0; currentCellIndex < STANDRAD_TITLE_CELL_COUNT; currentCellIndex++) {
                    HSSFCell currentCell = currentRow.getCell(currentCellIndex);

                    if (currentCell != null && currentCell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {

                        if (HSSFCell.CELL_TYPE_FORMULA == currentCell.getCellType()) {
                            return ServerResponse.createByErrorMessage("导入的表格中不可包含Excel公式。请在右上角下载标准模板导入!");
                        }

                        String currentCellContent = "";
                        ///判断单元格值的类型（日期型需要特殊处理8小时问题）
                        currentCell.setCellType(Cell.CELL_TYPE_STRING);
                        currentCellContent = currentCell.getStringCellValue() == null ? "" : currentCell.getStringCellValue();

                        rowDatas[currentCellIndex] = currentCellContent.trim();//将excel获取到的单元格值赋值给String类型的数组
                    } else {
                        rowDatas[currentCellIndex] = "";
                    }
                }
                dataList.add(rowDatas);
            }
        }
        return ServerResponse.createBySuccess(dataList);
    }

    private static int getNotBlankRows(HSSFSheet sheet) {
        for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            HSSFRow row = sheet.getRow(rowIndex);
            int cellDataCount = 0;
            for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                HSSFCell cell = row.getCell(cellIndex);
                if (cell != null && cell.getCellType() != HSSFCell.CELL_TYPE_BLANK) {
                    cellDataCount++;
                }
            }
            if (cellDataCount <= 0) {
                return rowIndex - 1;
            }
        }
        return sheet.getLastRowNum();
    }
}
