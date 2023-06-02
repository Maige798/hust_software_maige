package UI_System.CreateProject;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import SystemUtil.Language;
import SystemUtil.TranslationItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UI_FileListPanel extends JPanel {
    //左下
    public JLabel projectFileLabel = new JLabel();
    public JButton importFileButton = new JButton();
    public JButton deleteFileButton = new JButton();

    public List<String> fileNames = new ArrayList<>();
    public JTable fileTable = new JTable(4, 1);
    public JButton previousPage = new JButton();
    public JTextField pageNumber = new JTextField();
    public JButton nextPage = new JButton();
    //左上
    public JLabel projectNameLabel = new JLabel();
    public JTextField projectNameField = new JTextField();

    public JButton createButton = new JButton();

    public JLabel savePathLabel = new JLabel();
    public JTextField savePathField = new JTextField();

    public JButton browseButton = new JButton();

    //右上
    public JLabel beginLabel;
    public JComboBox<String> originLanguageComboBox;
    public JLabel goalLabel;
    public JComboBox<String> targetLanguageComboBox;


    public UI_FileListPanel() {
        this.setLayout(null);
        // this.setBackground(Color.blue);
//左下
        projectFileLabel.setText("项目文件");
        importFileButton.setText("导入文件");
        importFileButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_FileListPanel());
                if (option == JFileChooser.APPROVE_OPTION) {
                    fileNames.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(fileNames.get(fileNames.size() - 1));
                    UpdateTable(fileNames);
                }
            }
        });


        importFileButton.setMargin(new Insets(0, 0, 0, 0));
        deleteFileButton.setText("删除文件");
        deleteFileButton.setMargin(new Insets(0, 0, 0, 0));
        previousPage.setText("上一页");
        previousPage.setFont(new Font(null, Font.PLAIN, 10));
        previousPage.setMargin(new Insets(0, 0, 0, 0));
        nextPage.setText("下一页");
        nextPage.setFont(new Font(null, Font.PLAIN, 10));
        nextPage.setMargin(new Insets(0, 0, 0, 0));

        pageNumber.setHorizontalAlignment(JTextField.CENTER);

        this.add(projectFileLabel);
        this.add(importFileButton);
        this.add(deleteFileButton);
        this.add(fileTable);
        this.add(previousPage);
        this.add(nextPage);
        this.add(pageNumber);

        projectFileLabel.setBounds(60, 230, 60, 30);
        importFileButton.setBounds(60, 260, 60, 20);
        deleteFileButton.setBounds(130, 260, 60, 20);
        fileTable.setBounds(60, 300, 180, 80);
        //设置table的内容不可编辑
        fileTable.setEnabled(false);

        previousPage.setBounds(80, 400, 40, 20);
        nextPage.setBounds(170, 400, 40, 20);
        pageNumber.setBounds(130, 400, 30, 20);

//左上
        projectNameLabel.setText("项目名称");
        this.add(projectNameLabel);
        projectNameLabel.setBounds(60, 60, 60, 30);

        this.add(projectNameField);
        projectNameField.setBounds(60, 90, 200, 30);

        createButton.setText("创建");
        this.add(createButton);
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.setBounds(280, 90, 60, 30);
        createButton.addActionListener(e -> {
            OnCreateButtonDown();
        });

        savePathLabel.setText("位置路径");
        this.add(savePathLabel);
        savePathLabel.setBounds(60, 150, 60, 30);

        this.add(savePathField);
        savePathField.setBounds(60, 180, 200, 30);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(280, 180, 60, 30);
        //创建监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_FileListPanel());
                if (option == JFileChooser.APPROVE_OPTION) {
                    fileNames.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(fileNames.get(0));
                    UpdateSavePathButton(fileNames);
                }
            }
        });

        //右上
        beginLabel = new JLabel("源语言");
        goalLabel = new JLabel("目标语言");
        String[] language = Language.GetAllLanguageNames();
        originLanguageComboBox = new JComboBox<>(language);
        targetLanguageComboBox = new JComboBox<>(language);

        this.add(beginLabel);
        this.add(goalLabel);
        this.add(originLanguageComboBox);
        this.add(targetLanguageComboBox);

        beginLabel.setBounds(400, 60, 50, 30);
        goalLabel.setBounds(400, 150, 50, 30);
        originLanguageComboBox.setBounds(450, 60, 100, 30);
        targetLanguageComboBox.setBounds(450, 150, 100, 30);
    }

    private void OnCreateButtonDown() {
        if (AbleToCreate()) {
            String projectName = projectNameField.getText();
            String savePath = savePathField.getText();
            Language origin = Language.GetLanguage((String) originLanguageComboBox.getSelectedItem());
            Language target = Language.GetLanguage((String) targetLanguageComboBox.getSelectedItem());
            CAT_Project project = ProjectManager.CreateProject(projectName, savePath, origin, target);
            LoadTranslationFiles(project, origin, target);
        } else {
            System.err.println("Something has not finished, cannot create a new project.");
        }
    }

    // 当文件名、存储路径均已输入，源语言与目标语言都选择时，可以创建项目
    private boolean AbleToCreate() {
        if (projectNameField.getText().equals(""))
            return false;
        else if (savePathField.getText().equals(""))
            return false;
        else if (Objects.equals(originLanguageComboBox.getSelectedItem(), Language.Default.name))
            return false;
        else return !Objects.equals(targetLanguageComboBox.getSelectedItem(), Language.Default.name);
    }

    // 将
    private void LoadTranslationFiles(CAT_Project project,Language origin,Language target) {
        for (String save : fileNames) {
            TranslationFile file = TranslationFileManager.ReadFile(GetPureName(save), save, origin, target);
            project.AddTranslationFile(file);
        }
    }

    // 获得去除路径的文件名
    private String GetPureName(String save) {
        String[] files = save.split("\\\\");
        return files[files.length - 1];
    }

    private void UpdateTable(List<String> fileNames) {
        for (int i = 0; i < fileNames.size(); i++)
            fileTable.setValueAt(fileNames.get(i), i, 0);
    }

    private void UpdateSavePathButton(List<String> fileNames) {
        savePathField.setText(fileNames.get(fileNames.size() - 1));
    }
}
