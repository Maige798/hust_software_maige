/**
 * 类名：FileSystemWindow
 * 开发人员：王琢玉
 * 实现功能：设计实现文件框架，将文件各个面板的内容合并到contentPanel上来
 */

package UI_System;

import FileSystem.TranslationFile;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import UI_System.FileSysWin.UI_FileSysWin_ContentPanel;
import UI_System.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import java.awt.*;

public class FileSystemWindow extends JFrame {
    public UI_FileSysWin_ContentPanel FileSysWin_ContentPanel;
    public JMenuBar menuBar;

    public static void main(String[] args) {
        ProjectManager.OpenProject(ProjectManager.GetProject(1));
        FileSystemWindow win = new FileSystemWindow();
    }

    public FileSystemWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("项目文件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        FileSysWin_ContentPanel = new UI_FileSysWin_ContentPanel(this);

        //创建顶部菜单栏
        menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(FileSysWin_ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
