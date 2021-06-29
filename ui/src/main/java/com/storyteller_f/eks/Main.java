package com.storyteller_f.eks;

import com.google.gson.Gson;
import com.storyteller_f.eks.core.Config;
import com.storyteller_f.eks.core.KeywordInfo;
import com.storyteller_f.eks.output.Factory;
import com.storyteller_f.eks.output.Output;
import com.storyteller_f.eks.statistic.Statistic;
import com.storyteller_f.eks.viewModel.FileModel;
import com.storyteller_f.eks.viewModel.KeywordModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    String currentOpenFile;
    Gson gson = new Gson();
    JFrame jFrame;
    private JPanel panel1;
    private JList<String> fileList;
    private JButton addFileButton;
    private JButton openFileButton;
    private JButton startButton;
    private JButton outputResultButton;
    private JList<String> resultList;
    private JTextField maxRowField;
    private JTextField maxColField;
    private JButton addKeywordButton;
    private JButton button1;
    private Config config;
    private FileModel listModel = new FileModel();
    private List<KeywordInfo> keywordInfos = new ArrayList<>();
    private KeywordModel keywordModel = new KeywordModel(keywordInfos);

    public Main(JFrame jFrame) {
        this.jFrame = jFrame;
        fileList.setModel(listModel);
        resultList.setModel(keywordModel);
        addFileButton.addActionListener(e -> {
            if (config == null) return;
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(".xls") ||
                            f.getName().endsWith(".xlsx")||
                            f.getName().endsWith(".ods");
                }

                @Override
                public String getDescription() {
                    return "Excel 表格 .xls .xlsx";
                }
            });
            jFileChooser.setSelectedFile(new File("e:\\测试\\file.xls"));
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int chooserResult = jFileChooser.showOpenDialog(panel1);
            switch (chooserResult) {
                case JFileChooser.CANCEL_OPTION:
                case JFileChooser.ERROR_OPTION:
                    break;
                case JFileChooser.APPROVE_OPTION:
                    if (e.getSource().equals(addFileButton)) {
                        String path = jFileChooser.getSelectedFile().getAbsolutePath();
                        config.files.add(path);
                        fileList.updateUI();
                    }
                    break;
            }
        });
        openFileButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().endsWith(".json");
                }

                @Override
                public String getDescription() {
                    return "配置文件 .json";
                }
            });
            jFileChooser.setSelectedFile(new File("e:\\测试\\file.json"));
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int chooserResult = jFileChooser.showOpenDialog(panel1);
            switch (chooserResult) {
                case JFileChooser.CANCEL_OPTION:
                case JFileChooser.ERROR_OPTION:
                    break;
                case JFileChooser.APPROVE_OPTION:
                    if (e.getSource().equals(openFileButton)) {
                        String path = jFileChooser.getSelectedFile().getAbsolutePath();
                        currentOpenFile = path;
                        jFrame.setTitle("关键字统计-" + path);
                        //读取文件
                        try {
                            config = gson.fromJson(new FileReader(path), Config.class);
                            if (config == null) {
                                config = new Config();
                            }
                            listModel.config = config;
                            fileList.updateUI();
                            for (String keywordInfo : config.keywordInfos) {
                                keywordInfos.add(new KeywordInfo(keywordInfo));
                            }
                            resultList.updateUI();
                            maxRowField.setText(String.valueOf(config.maxRow));
                            maxColField.setText(String.valueOf(config.maxCol));
                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                            JOptionPane.showMessageDialog(panel1, fileNotFoundException.getMessage());
                        }
                    }
                    break;
            }
        });
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxRow = Integer.parseInt(maxRowField.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxRow = Integer.parseInt(maxRowField.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxRow = Integer.parseInt(maxRowField.getText());
                }
            }
        };
        maxRowField.getDocument().addDocumentListener(documentListener);
        maxColField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxCol = Integer.parseInt(maxColField.getText());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxCol = Integer.parseInt(maxColField.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (config != null) {
                    config.maxCol = Integer.parseInt(maxColField.getText());
                }
            }
        });
        addKeywordButton.addActionListener(e -> {
            String result = JOptionPane.showInputDialog(addKeywordButton, "想要添加的关键字");
            if (result != null) {
                keywordInfos.add(new KeywordInfo(result));
                config.keywordInfos.add(result);
                resultList.updateUI();
            }
        });
        startButton.addActionListener(e -> {
            panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            try {
                Statistic.statistic(keywordInfos, config);
            } catch (Exception ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(panel1, ioException.getMessage());
            } finally {
                panel1.setCursor(Cursor.getDefaultCursor());
                resultList.updateUI();
            }
        });
        button1.addActionListener(e -> {
            panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String s = gson.toJson(config);
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(currentOpenFile);
                fileWriter.write(s);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(panel1, ioException.getMessage());
            } finally {
                close(fileWriter);
                panel1.setCursor(Cursor.getDefaultCursor());
            }
        });
        outputResultButton.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    return Arrays.stream(Factory.filter()).anyMatch(s -> f.getName().endsWith(s));
                }

                @Override
                public String getDescription() {
                    return "";
                }
            });
            jFileChooser.setSelectedFile(new File("e:\\测试\\file.json"));
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int chooserResult = jFileChooser.showOpenDialog(panel1);
            switch (chooserResult) {
                case JFileChooser.CANCEL_OPTION:
                case JFileChooser.ERROR_OPTION:
                    break;
                case JFileChooser.APPROVE_OPTION:
                    if (e.getSource().equals(outputResultButton)) {
                        String path = jFileChooser.getSelectedFile().getAbsolutePath();
                        System.out.println("output:" + path);
                        Output output = Factory.getOutput(path);
                        if (output != null) {
                            try {
                                panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                                output.writeTo(keywordInfos);
                                JOptionPane.showMessageDialog(panel1, "保存成功");
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                                JOptionPane.showMessageDialog(panel1, ioException.getMessage());
                            } finally {
                                panel1.setCursor(Cursor.getDefaultCursor());
                            }
                        } else {
                            System.out.println("output is null");
                        }
                    }
                    break;
            }
        });
    }

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("关键字统计");
        Main main = new Main(jFrame);
        jFrame.setContentPane(main.panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(400, 400);
    }

    private void close(FileWriter fileWriter) {
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
