package com.storyteller_f.eks.output;

import java.io.File;

public class Factory {
    public static Output getOutput(String path) {
        File file=new File(path);
        int i = file.getName().lastIndexOf(".");
        if (i > 0) {
            String extension=file.getName().substring(i+1);
            switch (extension) {
                case "html":
                    return new HTMLTableOutput(path);
                case "xlsx":
                    return new XlsxOutput(path);
                case "xls":
                    return new XlsOutput(path);
                case "ods":
                    return new OdsOutput(path);
            }
        }
        return null;
    }

    public static String[] filter() {
        return new String[]{
                ".html",
                ".xls",
                ".xlsx",
                ".ods"
        };
    }
}
