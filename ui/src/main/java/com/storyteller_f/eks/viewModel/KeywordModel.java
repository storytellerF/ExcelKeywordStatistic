package com.storyteller_f.eks.viewModel;

import com.storyteller_f.eks.core.KeywordInfo;

import javax.swing.*;
import java.util.List;

public class KeywordModel extends AbstractListModel<String> {
    List<KeywordInfo> keywordInfos;

    public KeywordModel(List<KeywordInfo> keywordInfos) {
        this.keywordInfos = keywordInfos;
    }

    @Override
    public int getSize() {
        return keywordInfos.size();
    }

    @Override
    public String getElementAt(int index) {
        KeywordInfo keywordInfo = keywordInfos.get(index);
        return keywordInfo.keyword+" "+keywordInfo.count;
    }
}
