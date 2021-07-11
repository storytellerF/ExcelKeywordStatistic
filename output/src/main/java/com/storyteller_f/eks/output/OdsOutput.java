package com.storyteller_f.eks.output;

import com.storyteller_f.eks.core.KeywordInfo;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Row;
import org.odftoolkit.simple.table.Table;

import java.io.IOException;
import java.util.List;

public class OdsOutput extends Output {
    public OdsOutput(String path) {
        super(path);
    }

    @Override
    public void writeTo(List<KeywordInfo> keywordInfos) throws IOException {
        try {
            int index=0;
            SpreadsheetDocument chartDocument = SpreadsheetDocument.newSpreadsheetDocument();
            if (chartDocument.getSheetCount() == 0) {
                chartDocument.appendSheet("默认");
            }
            Table table = chartDocument.getSheetByIndex(0);
            {
                Row row = table.getRowByIndex(index++);
                row.getCellByIndex(0).setStringValue("关键字");
                row.getCellByIndex(1).setStringValue("个数");
            }
            for (KeywordInfo keywordInfo : keywordInfos) {
                Row row = table.getRowByIndex(index++);

                row.getCellByIndex(0).setStringValue(keywordInfo.keyword);
                row.getCellByIndex(1).setDoubleValue((double) keywordInfo.count);
            }
            chartDocument.save(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
