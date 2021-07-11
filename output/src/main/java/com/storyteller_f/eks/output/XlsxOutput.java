package com.storyteller_f.eks.output;

import com.storyteller_f.eks.core.KeywordInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsxOutput extends Output {
    public XlsxOutput(String path) {
        super(path);
    }

    @Override
    public void writeTo(List<KeywordInfo> keywordInfos) throws IOException {
        Workbook xssfWorkbook= getXssfWorkbook();
        Sheet defaultSheet = xssfWorkbook.createSheet("默认Sheet");
        {
            Row row = defaultSheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("关键字");
            Cell xssfCell=row.createCell(1);
            xssfCell.setCellValue("个数");
        }

        int index=1;
        for (KeywordInfo keywordInfo : keywordInfos) {
            Row row = defaultSheet.createRow(index++);
            Cell cell = row.createCell(0);
            cell.setCellValue(keywordInfo.keyword);
            Cell xssfCell=row.createCell(1);
            xssfCell.setCellValue(keywordInfo.count);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            xssfWorkbook.write(fileOutputStream);
        }
    }

    public Workbook getXssfWorkbook() {
        return new XSSFWorkbook();
    }

}
