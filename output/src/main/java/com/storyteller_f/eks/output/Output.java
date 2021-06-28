package com.storyteller_f.eks.output;

import com.storyteller_f.eks.core.KeywordInfo;

import java.io.IOException;
import java.util.List;

public abstract class Output {
    public String path;

    public Output(String path) {
        this.path = path;
    }

    public abstract void writeTo(List<KeywordInfo> keywordInfos) throws IOException;
}
