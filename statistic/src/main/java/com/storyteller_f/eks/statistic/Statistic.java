package com.storyteller_f.eks.statistic;

import com.storyteller_f.eks.core.Config;
import com.storyteller_f.eks.core.KeywordInfo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Statistic {
    /**
     * @param keywordInfos 关键字列表，结果也存储到这里
     * @param config       用来获取所有的文件
     */
    public static void statistic(List<KeywordInfo> keywordInfos, Config config) throws IOException, InvalidFormatException {
        //遍历所有文件
        for (String file : config.files) {
            System.out.println("file:" + file);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            int numberOfSheets = workbook.getNumberOfSheets();
            System.out.println("sheet 个数:" + numberOfSheets);
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            while (sheetIterator.hasNext()) {
                Sheet next = sheetIterator.next();
                for (int i = 0; i < config.maxRow; i++) {
                    Row row = next.getRow(i);
                    if (row != null)
                        for (int j = 0; j < config.maxCol; j++) {
                            Cell cell = row.getCell(j);
                            if (cell != null) {
                                if (cell.getCellType() == CellType.STRING) {
                                    String stringCellValue = cell.getStringCellValue();
                                    //遍历关键字列表
                                    if (stringCellValue.length() > 0)
                                        for (KeywordInfo keywordInfo : keywordInfos) {
                                            if (stringCellValue.contains(keywordInfo.keyword)) {
                                                keywordInfo.count++;
                                            }
                                        }
                                }

                            }

                        }
                }
            }
            fileInputStream.close();
            workbook.close();
        }


    }
}
