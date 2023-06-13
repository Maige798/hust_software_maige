/**
 * 类名：UI_FileListPanel
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，列表翻页
 * 2.开发人员：刘闯
 * 实现功能：实现创建项目界面面板组件
 */

package UI_System.CreateProject;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import SystemUtil.Language;
import UI_System.FileSystemWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UI_FileListPanel extends JPanel {
    public static final int tableSize = 4;

    public JFrame frame;

    //左下
    public JLabel projectFileLabel = new JLabel();
    public JButton importFileButton = new JButton();
    public JButton deleteFileButton = new JButton();

    public int currentPage = 0;
    public List<String> fileNames = new ArrayList<>();
    public JTable fileTable = new JTable(tableSize, 1);
    public JButton formerPage = new JButton();
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
                    UpdateTable();
                }
            }
        });


        importFileButton.setMargin(new Insets(0, 0, 0, 0));
        deleteFileButton.setText("删除文件");
        deleteFileButton.setMargin(new Insets(0, 0, 0, 0));
        deleteFileButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = fileTable.getSelectedRow();
                Object selectedRow = fileTable.getValueAt(a, 0);
                OnDeleteButtonDown((String) selectedRow);
            }
        });


        formerPage.setText("上一页");
        formerPage.setFont(new Font(null, Font.PLAIN, 10));
        formerPage.setMargin(new Insets(0, 0, 0, 0));
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage.setText("下一页");
        nextPage.setFont(new Font(null, Font.PLAIN, 10));
        nextPage.setMargin(new Insets(0, 0, 0, 0));
        nextPage.addActionListener(e -> OnNextPageButtonDown());

        pageNumber.setHorizontalAlignment(JTextField.CENTER);

        this.add(projectFileLabel);
        this.add(importFileButton);
        this.add(deleteFileButton);
        this.add(fileTable);
        this.add(formerPage);
        this.add(nextPage);
        this.add(pageNumber);

        projectFileLabel.setBounds(60, 230, 60, 30);
        importFileButton.setBounds(60, 260, 60, 20);
        deleteFileButton.setBounds(130, 260, 60, 20);
        fileTable.setBounds(60, 300, 180, 64);

        formerPage.setBounds(80, 400, 40, 20);
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
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(new UI_FileListPanel());
                if (option == JFileChooser.APPROVE_OPTION)
                    savePathField.setText(fileChooser.getSelectedFile().getAbsolutePath() + "\\");
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
        UpdateTable();
    }

    private void OnCreateButtonDown() {
        if (AbleToCreate()) {
            String projectName = projectNameField.getText();
            String savePath = savePathField.getText();
            Language origin = Language.GetLanguage((String) originLanguageComboBox.getSelectedItem());
            Language target = Language.GetLanguage((String) targetLanguageComboBox.getSelectedItem());
            CAT_Project project = ProjectManager.CreateProject(projectName, savePath, origin, target);
            LoadTranslationFiles(project, origin, target);
            FileSystemWindow window=new FileSystemWindow();
            frame.dispose();
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

    private void LoadTranslationFiles(CAT_Project project, Language origin, Language target) {
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

    // 获得当前页的的全部名称
    private String[] GetCurrentPageNames() {
        String[] names = new String[tableSize];
        for (int i = 0; i < tableSize && tableSize * currentPage + i < fileNames.size(); i++)
            names[i] = fileNames.get(tableSize * currentPage + i);
        return names;
    }

    private void UpdatePageNumber() {
        pageNumber.setText((currentPage + 1) + "/" + ((fileNames.size() - 1) / tableSize + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPage > 0)
            currentPage--;
        UpdateTable();
    }

    private void OnNextPageButtonDown() {
        if (currentPage < (fileNames.size() - 1) / tableSize)
            currentPage++;
        UpdateTable();
    }

    private void UpdateTable() {
        String[] names = GetCurrentPageNames();
        for (int i = 0; i < tableSize; i++)
            fileTable.setValueAt("", i, 0);
        for (int i = 0; i < names.length; i++)
            fileTable.setValueAt(names[i], i, 0);
        UpdatePageNumber();
    }

    private void OnDeleteButtonDown(String selectedString) {
        fileNames.removeIf(s -> s.equals(selectedString));
        UpdateTable();
    }
}
