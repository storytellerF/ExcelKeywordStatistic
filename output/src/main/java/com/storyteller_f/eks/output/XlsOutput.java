package com.storyteller_f.eks.output;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class XlsOutput extends XlsxOutput{
    public XlsOutput(String path) {
        super(path);
    }

    @Override
    public Workbook getXssfWorkbook() {
        return new HSSFWorkbook();
    }
}
