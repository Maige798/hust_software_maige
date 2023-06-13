/**
 * 类名：FileImportWindow
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，向当前项目中导入新的翻译文件
 * 2.开发人员：刘闯
 * 实现功能：创建文件导入界面
 */

package UI_System;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FileImportWindow extends JFrame {
    public TextField createTextField = new TextField();
    public FileSystemWindow fileSystemWindow;

    public JButton browseButton = new JButton();
    public JButton importButton;

    public FileImportWindow(FileSystemWindow fileSystemWindow) {
        this.fileSystemWindow = fileSystemWindow;
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("文件导入");

        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.add(createTextField);
        createTextField.setBounds(50, 130, 350, 30);

        browseButton.setText("浏览");
        panel.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(425, 130, 50, 30);
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    createTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        importButton = new JButton("导入");
        panel.add(importButton);
        importButton.setMargin(new Insets(0, 0, 0, 0));
        importButton.setBounds(225, 250, 100, 30);
        importButton.addActionListener(e -> OnImportButtonDown());

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void OnImportButtonDown() {
        if (!createTextField.getText().equals("") && ProjectManager.instance.currentProject != null) {
            CAT_Project project = ProjectManager.instance.currentProject;
            String sourceFile = createTextField.getText();
            String name = GetPureName(sourceFile);
            TranslationFile file = TranslationFileManager.ReadFile(name, sourceFile, project.originLanguage, project.targetLanguage);
            TranslationFileManager.SaveFile(file);
            project.AddTranslationFile(file);
            ProjectManager.SaveProject(project);
            fileSystemWindow.FileSysWin_ContentPanel.FileListPanel.UpdateNamesAndSaves();
            fileSystemWindow.FileSysWin_ContentPanel.FileListPanel.UpdateFileItemTableByCurrentPage();
            dispose();
        }
    }

    public static void main(String[] args) {
        new FileImportWindow(null);
    }

    private String GetPureName(String save) {
        String[] messages = save.split("\\\\");
        return messages[messages.length - 1];
    }
}
