package com.xjt.utils;


import com.xjt.common.ExceptionResultInfo;
import com.xjt.common.ResultInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by hs on 2017-06-17.
 */
public class ProjectGenerateSqlFromExcel {
    public static ArrayList<String[]> generateUserSql(InputStream inputStream)
            throws Exception {
        if (inputStream == null) {
            throw new Exception("没有文件导入");
        }
        /*不支持2007以上版本**/
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);//通过输入流使内存获得Excel文件
        HSSFSheet sheet = null;
        //判断是否是模板   如果获得第一个sheet的第一行是否是模板中的标题
        sheet = workbook.getSheetAt(0);
        HSSFCell titleCell1 = sheet.getRow(1).getCell(0);
        HSSFCell titleCell2 = sheet.getRow(1).getCell(1);
        HSSFCell titleCell3 = sheet.getRow(1).getCell(2);
        HSSFCell titleCell4 = sheet.getRow(1).getCell(3);
        HSSFCell titleCell5 = sheet.getRow(1).getCell(4);
        HSSFCell titleCell6 = sheet.getRow(1).getCell(5);
        HSSFCell titleCell7 = sheet.getRow(1).getCell(6);
        HSSFCell titleCell8 = sheet.getRow(1).getCell(7);
        HSSFCell titleCell9 = sheet.getRow(1).getCell(8);
        HSSFCell titleCell10 = sheet.getRow(1).getCell(9);
        HSSFCell titleCell11 = sheet.getRow(1).getCell(10);
        HSSFCell titleCell12 = sheet.getRow(1).getCell(11);
        HSSFCell titleCell13 = sheet.getRow(1).getCell(12);
        HSSFCell titleCell14 = sheet.getRow(1).getCell(13);
        HSSFCell titleCell15 = sheet.getRow(1).getCell(14);
        HSSFCell titleCell16 = sheet.getRow(1).getCell(15);
        HSSFCell titleCell17 = sheet.getRow(1).getCell(16);
        HSSFCell titleCell18 = sheet.getRow(1).getCell(17);
        HSSFCell titleCell19 = sheet.getRow(1).getCell(18);
        HSSFCell titleCell20 = sheet.getRow(1).getCell(19);
        HSSFCell titleCell21 = sheet.getRow(1).getCell(20);
        HSSFCell titleCell22 = sheet.getRow(1).getCell(21);
        HSSFCell titleCell23 = sheet.getRow(1).getCell(22);
        HSSFCell titleCell24 = sheet.getRow(1).getCell(23);
        HSSFCell titleCell25 = sheet.getRow(1).getCell(24);
        HSSFCell titleCell26 = sheet.getRow(1).getCell(25);
        HSSFCell titleCell27 = sheet.getRow(1).getCell(26);
        HSSFCell titleCell28 = sheet.getRow(1).getCell(27);
        HSSFCell titleCell29 = sheet.getRow(1).getCell(28);
        HSSFCell titleCell30 = sheet.getRow(1).getCell(29);
        HSSFCell titleCell31 = sheet.getRow(1).getCell(30);
        HSSFCell titleCell32 = sheet.getRow(1).getCell(31);
        HSSFCell titleCell33 = sheet.getRow(1).getCell(32);
        HSSFCell titleCell34 = sheet.getRow(1).getCell(33);
        HSSFCell titleCell35 = sheet.getRow(1).getCell(34);
        HSSFCell titleCell36 = sheet.getRow(1).getCell(35);
        HSSFCell titleCell37 = sheet.getRow(1).getCell(36);
        HSSFCell titleCell38 = sheet.getRow(1).getCell(37);
        HSSFCell titleCell39 = sheet.getRow(1).getCell(38);
        String titleValue1;
        String titleValue2;
        String titleValue3;
        String titleValue4;
        String titleValue5;
        String titleValue6;
        String titleValue7;
        String titleValue8;
        String titleValue9;
        String titleValue10;
        String titleValue11;
        String titleValue12;
        String titleValue13;
        String titleValue14;
        String titleValue15;
        String titleValue16;
        String titleValue17;
        String titleValue18;
        String titleValue19;
        String titleValue20;
        String titleValue21;
        String titleValue22;
        String titleValue23;
        String titleValue24;
        String titleValue25;
        String titleValue26;
        String titleValue27;
        String titleValue28;
        String titleValue29;
        String titleValue30;
        String titleValue31;
        String titleValue32;
        String titleValue33;
        String titleValue34;
        String titleValue35;
        String titleValue36;
        String titleValue37;
        String titleValue38;
        String titleValue39;
        if (titleCell1 == null) {
            titleValue1 = "";
        } else {
            titleValue1 = titleCell1.getStringCellValue();
        }
        if (titleCell2 == null) {
            titleValue2 = "";
        } else {
            titleValue2 = titleCell2.getStringCellValue();
        }
        if (titleCell3 == null) {
            titleValue3 = "";
        } else {
            titleValue3 = titleCell3.getStringCellValue();
        }
        if (titleCell4 == null) {
            titleValue4 = "";
        } else {
            titleValue4 = titleCell4.getStringCellValue();
        }
        if (titleCell5 == null) {
            titleValue5 = "";
        } else {
            titleValue5 = titleCell5.getStringCellValue();
        }
        if (titleCell6 == null) {
            titleValue6 = "";
        } else {
            titleValue6 = titleCell6.getStringCellValue();
        }
        if (titleCell7 == null) {
            titleValue7 = "";
        } else {
            titleValue7 = titleCell7.getStringCellValue();
        }
        if (titleCell8 == null) {
            titleValue8 = "";
        } else {
            titleValue8 = titleCell8.getStringCellValue();
        }
        if (titleCell9 == null) {
            titleValue9 = "";
        } else {
            titleValue9 = titleCell9.getStringCellValue();
        }
        if (titleCell10 == null) {
            titleValue10 = "";
        } else {
            titleValue10 = titleCell10.getStringCellValue();
        }
        if (titleCell11 == null) {
            titleValue11 = "";
        } else {
            titleValue11 = titleCell11.getStringCellValue();
        }
        if (titleCell12 == null) {
            titleValue12 = "";
        } else {
            titleValue12 = titleCell12.getStringCellValue();
        }
        if (titleCell13 == null) {
            titleValue13 = "";
        } else {
            titleValue13 = titleCell13.getStringCellValue();
        }
        if (titleCell14 == null) {
            titleValue14 = "";
        } else {
            titleValue14 = titleCell14.getStringCellValue();
        }
        if (titleCell15 == null) {
            titleValue15 = "";
        } else {
            titleValue15 = titleCell15.getStringCellValue();
        }
        if (titleCell16 == null) {
            titleValue16 = "";
        } else {
            titleValue16 = titleCell16.getStringCellValue();
        }
        if (titleCell17 == null) {
            titleValue17 = "";
        } else {
            titleValue17 = titleCell17.getStringCellValue();
        }
        if (titleCell18 == null) {
            titleValue18 = "";
        } else {
            titleValue18 = titleCell18.getStringCellValue();
        }
        if (titleCell19 == null) {
            titleValue19 = "";
        } else {
            titleValue19 = titleCell19.getStringCellValue();
        }
        if (titleCell20 == null) {
            titleValue20 = "";
        } else {
            titleValue20 = titleCell20.getStringCellValue();
        }
        if (titleCell21 == null) {
            titleValue21 = "";
        } else {
            titleValue21 = titleCell21.getStringCellValue();
        }
        if (titleCell22 == null) {
            titleValue22 = "";
        } else {
            titleValue22 = titleCell22.getStringCellValue();
        }
        if (titleCell23 == null) {
            titleValue23 = "";
        } else {
            titleValue23 = titleCell23.getStringCellValue();
        }
        if (titleCell24 == null) {
            titleValue24 = "";
        } else {
            titleValue24 = titleCell24.getStringCellValue();
        }
        if (titleCell25 == null) {
            titleValue25 = "";
        } else {
            titleValue25 = titleCell25.getStringCellValue();
        }
        if (titleCell26 == null) {
            titleValue26 = "";
        } else {
            titleValue26 = titleCell26.getStringCellValue();
        }
        if (titleCell27 == null) {
            titleValue27 = "";
        } else {
            titleValue27 = titleCell27.getStringCellValue();
        }
        if (titleCell28 == null) {
            titleValue28 = "";
        } else {
            titleValue28 = titleCell28.getStringCellValue();
        }
        if (titleCell29 == null) {
            titleValue29 = "";
        } else {
            titleValue29 = titleCell29.getStringCellValue();
        }
        if (titleCell30 == null) {
            titleValue30 = "";
        } else {
            titleValue30 = titleCell30.getStringCellValue();
        }
        if (titleCell31 == null) {
            titleValue31 = "";
        } else {
            titleValue31 = titleCell31.getStringCellValue();
        }
        if (titleCell32 == null) {
            titleValue32 = "";
        } else {
            titleValue32 = titleCell32.getStringCellValue();
        }
        if (titleCell33 == null) {
            titleValue33 = "";
        } else {
            titleValue33 = titleCell33.getStringCellValue();
        }
        if (titleCell34 == null) {
            titleValue34 = "";
        } else {
            titleValue34 = titleCell34.getStringCellValue();
        }
        if (titleCell35 == null) {
            titleValue35 = "";
        } else {
            titleValue35 = titleCell35.getStringCellValue();
        }
        if (titleCell36 == null) {
            titleValue36 = "";
        } else {
            titleValue36 = titleCell36.getStringCellValue();
        }
        if (titleCell37 == null) {
            titleValue37 = "";
        } else {
            titleValue37 = titleCell37.getStringCellValue();
        }
        if (titleCell38 == null) {
            titleValue38 = "";
        } else {
            titleValue38 = titleCell38.getStringCellValue();
        }
        if (titleCell39 == null) {
            titleValue39 = "";
        } else {
            titleValue39 = titleCell39.getStringCellValue();
        }


        if (sheet != null) {
            if (sheet.getRow(0) == null) {
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setMessage("导入的表格不是标准模板。请在右上角下载模板导入!");
                throw new ExceptionResultInfo(resultInfo);
            } else if (!titleValue1.trim().equals("序号") || !titleValue2.trim().equals("项目所属年度") || !titleValue3.trim().equals("项目名称") ||
                    !titleValue4.trim().equals("项目类别") || !titleValue5.trim().equals("项目状态") || !titleValue6.trim().equals("项目主管单位") ||
                    !titleValue7.trim().equals("乡镇")||!titleValue8.trim().equals("村") || !titleValue9.trim().equals("实施主体") || !titleValue10.trim().equals("建设详细地址") ||
                    !titleValue11.trim().equals("建设性质") || !titleValue12.trim().equals("实施年度") || !titleValue13.trim().equals("完结年度") ||
                    !titleValue14.trim().equals("建设周期") || !titleValue15.trim().equals("是否贫困村") || !titleValue16.trim().equals("覆盖贫困村") ||
                    !titleValue17.trim().equals("绩效目标") || !titleValue18.trim().equals("是否统筹整合项目") || !titleValue19.trim().equals("资金文号来源") ||
                    !titleValue20.trim().equals("县文件号") ||!titleValue21.trim().equals("对应整合资金目录类型") || !titleValue22.trim().equals("指标下达功能科目") ||
                    !titleValue23.trim().equals("整合后功能科目") ||!titleValue24.trim().equals("统筹资金规模") || !titleValue25.trim().equals("项目建设规模及内容") ||
                    !titleValue26.trim().equals("受益非贫困户") ||!titleValue27.trim().equals("受益非贫困人口") || !titleValue28.trim().equals("受益贫困户") ||
                    !titleValue29.trim().equals("受益贫困人口") || !titleValue30.trim().equals("项目负责人") || !titleValue31.trim().equals("联系方式") ||
                    !titleValue32.trim().equals("社会效益")|| !titleValue33.trim().equals("经济效益")||
                    !titleValue34.trim().equals("本次拟申请资金")|| !titleValue35.trim().equals("中央资金")||
                    !titleValue36.trim().equals("省级资金")|| !titleValue37.trim().equals("市级资金")|| !titleValue38.trim().equals("县级资金")||
                    !titleValue39.trim().equals("社会资金")) {//判断标题是否正确
                ResultInfo resultInfo = new ResultInfo();
                resultInfo.setMessage("导入的表格不是标准模板。请在右上角下载模板导入!");
                throw new ExceptionResultInfo(resultInfo);

            } else {
                HSSFCell titleCell = sheet.getRow(0).getCell(0);
                String titleValue = titleCell.getStringCellValue();
                if (!titleValue.contains("项目批量导入模板")) {
                    ResultInfo resultInfo = new ResultInfo();
                    resultInfo.setMessage("导入的表格不是标准模板。请在右上角下载模板导入!");
                    throw new ExceptionResultInfo(resultInfo);

                }
            }


        } else {
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setMessage("导入的表格不是标准模板。请在右上角下载模板导入!");
            throw new ExceptionResultInfo(resultInfo);

        }


        ArrayList<String[]> list = new ArrayList<String[]>();//返回的结果集
        sheet = workbook.getSheetAt(0);
        //从excel的第二行开始读数据内容
        for (int j = 2; j <= sheet.getLastRowNum(); j++) {//循环每个工作表中的各行row
            String[] valStr = new String[50];//准备接受存放一行row中各cell的值
            HSSFRow row = sheet.getRow(j);
            if (row != null) {

                //判断该行是否为空行
                int num = 0;

                for (int t = 0; t <= 38; t++) {
                    HSSFCell cell = row.getCell(t);
                    if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                        num++;
                    }

                }

                if (num < 37) {
                    for (int k = 0; k < row.getLastCellNum(); k++) {//循环每行中的各列cell   9
                        System.out.print(row.getCell(k) + "\t");

                        Cell cell = row.getCell(k);//获得一个单元格
                        String content = "";  //存放一个单元格中的值


                        //如果单元格不为空
                        if (cell != null) {
                            if (HSSFCell.CELL_TYPE_FORMULA == cell.getCellType()) {
                                ResultInfo resultInfo = new ResultInfo();
                                resultInfo.setMessage("Excel表格有误，请仔细检查是否有公式！");
                                throw new ExceptionResultInfo(resultInfo);
                            }

                            ///判断单元格值的类型（日期型需要特殊处理8小时问题）
                            if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {//判断是否是数字型 ：日期也是数字型的一种
                                System.out.println("数字型");

                      /*  if (DateUtil.isCellDateFormatted(cell)) {//如果是日期型特殊处理
                            Date dateCellValue = cell.getDateCellValue();
                            long eighthour = 8 * 60 * 60 * 1000;
                            long time = dateCellValue.getTime() - eighthour;//获得正确时间毫秒数
                            java.util.Date date = new java.util.Date();//创建生成正确的时间
                            date.setTime(time);
                            SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            content = simpledate.format(date);
                        }*/
                                //普通数值型
                                String tempcontent = Double.toString(cell.getNumericCellValue());
                                content = tempcontent.trim();
                            } else {//如果是字符型
                                String tempcontent = cell.getStringCellValue() == null ? "" : cell.getStringCellValue();
                                content = tempcontent.trim();
                            }
                            valStr[k] = content;//将excel获取到的单元格值赋值给String类型的数组
                        } else {
                            //单元格为空
                            valStr[k] = "";
                        }

                    }
                    list.add(valStr);
                }


            }
            //每循环一行list接收一下数据

            System.out.print("/b");

        }
        System.out.println("---Sheet表" + 0 + "处理完毕---");

        return list;
    }


}
