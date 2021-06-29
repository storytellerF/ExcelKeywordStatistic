package com.storyteller_f.eks.statistic;

import com.storyteller_f.eks.core.Config;
import com.storyteller_f.eks.core.KeywordInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class Statistic {

    public static Workbook get(String path) throws Exception {
        int i = path.lastIndexOf(".");
        if (i > 0) {
            String substring = path.substring(i);
            switch (substring) {
                case ".xlsx":
                    return new XSSFWorkbook(path);
                case ".xls":
                    return new HSSFWorkbook(new BufferedInputStream(new FileInputStream(path)));
                case ".ods":
                    return new ODFWorkbook(path);
                default:
                    return null;
            }
        }
        return null;
    }

    /**
     * @param keywordInfos 关键字列表，结果也存储到这里
     * @param config       用来获取所有的文件
     */
    public static void statistic(List<KeywordInfo> keywordInfos, Config config) {
        //遍历所有文件
        config.files.stream()
                .filter(Objects::nonNull)
                .map(fileInputStream -> {
                    try {
                        return get(fileInputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .flatMap((Function<Workbook, Stream<Sheet>>) sheets -> {
                    Stream.Builder<Sheet> builder = Stream.builder();
                    for (int i = 0; i < sheets.getNumberOfSheets(); i++) {
                        builder.add(sheets.getSheetAt(i));
                    }
                    return builder.build();
                })
                .flatMap((Function<Sheet, Stream<Row>>) rows -> {
                    Stream.Builder<Row> builder = Stream.builder();
                    for (int i = 0; i < config.maxRow; i++) {
                        builder.add(rows.getRow(i));
                    }
                    return builder.build();
                })
                .filter(Objects::nonNull)
                .flatMap((Function<Row, Stream<Cell>>) cells -> {
                    Stream.Builder<Cell> builder = Stream.builder();
                    for (int i = 0; i < config.maxCol; i++) {
                        builder.add(cells.getCell(i));
                    }
                    return builder.build();
                })
                .filter(Objects::nonNull)
                .filter(cell -> cell.getCellType() == CellType.STRING)
                .map(Cell::getStringCellValue)
                .filter(s -> s.trim().length() > 0)
                .forEach(s -> {
                    for (KeywordInfo keywordInfo : keywordInfos) {
                        if (s.contains(keywordInfo.keyword)) {
                            keywordInfo.count++;
                        }
                    }
                });

    }
}
