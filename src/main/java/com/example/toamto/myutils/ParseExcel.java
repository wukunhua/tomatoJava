package com.example.toamto.myutils;

import cn.hutool.core.date.DateTime;
import com.microsoft.schemas.office.office.STInsetMode;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
//todo:改为文件流接收
public class ParseExcel {

    public static void main(String args[]) throws IOException {
        Workbook workbook = new HSSFWorkbook(new FileInputStream("C://Users//23034//Documents//WeChat Files//wxid_wtntjiox9u4h22//FileStorage//File//2024-03//福牛03.24.xls"));
        Sheet sheet = workbook.getSheetAt(0);
        // 获取标题内容
        Row rowTitle = sheet.getRow(0);
        if (rowTitle != null) {
            // 读取多少列有数据
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                Cell cell = rowTitle.getCell(cellNum);
                if (cell != null) {
                    CellType cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    //System.out.print(cellValue + "|");
                }
               // System.out.println();
            }
        }
        // 获取表中的内容
        int rowCount = sheet.getNumMergedRegions();
        int cellIndex = 0;
        int rowIndex = 0;
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);
            if (rowData != null) {
                // 读取列
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    //System.out.print("[" + (rowNum+1) + "-" + (cellNum+1) + "]");

                    Cell cell = rowData.getCell(cellNum);
                    // 匹配列的数据类型
                    if (cell != null) {
                        CellType cellType = cell.getCellType();
                        String cellValue = "";

                        switch (cellType) {
                            case STRING: // 字符串
                               // System.out.print("[String]");
                                cellValue = cell.getStringCellValue();
                                break;
                            case BOOLEAN: // 字符串
                               // System.out.print("[boolean]");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK: // 空
                                //System.out.print("[blank]");
                                break;
                            case NUMERIC: // 数字（日期）
                                //System.out.println("[numeric]");
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {   // 日期
                                    //System.out.print("[日期]");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                } else {
                                    // 不是日期格式，防止数字过长！
                                    //System.out.print("[转化为字符串输出]");
                                    cell.setCellType(CellType.STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case ERROR: // 空
                                //System.out.print("[数据类型错误]");
                                break;
                            case FORMULA:
//                                FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
//                                String formula = cell.getCellFormula();
//                                System.out.println(formula);
//                                // 计算
//                                CellValue evaluate = formulaEvaluator.evaluate(cell);
//                                cellValue = evaluate.formatAsString();
//                                System.out.println(cellValue);
                                break;
                        }

                       // System.out.println(cellValue);
                        if(cellValue.contains("小计")){
                            cellIndex = cellNum;
                        }
                        if(cellValue.contains("费用合计")){
                            rowIndex = rowNum;
                        }
                    }
                }
            }
        }

        FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
        Cell cell = sheet.getRow(rowIndex).getCell(cellIndex);
        // 计算
        CellValue evaluate = formulaEvaluator.evaluate(cell);
        String cellValue = evaluate.formatAsString();
        System.out.println("该表和："+cellValue);
    }
}
