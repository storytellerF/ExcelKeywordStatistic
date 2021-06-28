package com.storyteller_f.eks.output;

import com.storyteller_f.eks.core.KeywordInfo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLTableOutput extends Output{
    public HTMLTableOutput(String path) {
        super(path);
    }

    @Override
    public void writeTo( List<KeywordInfo> keywordInfos) throws IOException {
        FileWriter fileWriter=new FileWriter(path);
        fileWriter.write("<table>");
        for (KeywordInfo keywordInfo : keywordInfos) {
            fileWriter.write("<tr><td>"+keywordInfo.keyword+"</td><td>"+keywordInfo.count+"</td></td>");
        }
        fileWriter.write("</table>");
        fileWriter.flush();
        fileWriter.close();
    }
}
