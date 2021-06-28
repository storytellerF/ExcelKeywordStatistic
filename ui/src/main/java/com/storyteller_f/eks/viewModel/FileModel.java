package com.storyteller_f.eks.viewModel;

import com.storyteller_f.eks.core.Config;

import javax.swing.*;

public class FileModel extends AbstractListModel<String> {
        public Config config;
    @Override
    public int getSize() {
        if (config==null) return 0;
        return config.files.size();
    }

    @Override
    public String getElementAt(int index) {
        return config.files.get(index);
    }
}
