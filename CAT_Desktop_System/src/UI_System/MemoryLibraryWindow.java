/**
 * 类名：MemoryLibraryWindow
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System;

import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.MemLibWin.UI_MemLib_ContentPanel;


import javax.swing.*;
import java.awt.*;

public class MemoryLibraryWindow extends JFrame {
    //创建顶部菜单栏
    public JMenuBar menuBar;


    //创建内容面板
    public JPanel ContentPanel;

    public static void main(String[] args) {
        ProjectManager.OpenProject(ProjectManager.GetProject(0));
        MemoryLibraryWindow windows = new MemoryLibraryWindow();
    }

    public static void test() {
        String myFile = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\ProjectSystem\\MyProject.catp";
        CAT_Project project = ProjectManager.LoadProject(myFile);
        ProjectManager.OpenProject(project);
        MemoryLibraryWindow windows = new MemoryLibraryWindow();
    }

    public MemoryLibraryWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("翻译记忆库");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建顶部菜单栏
        menuBar = new UI_JMenuBar();

        //创建内容面板
        ContentPanel = new UI_MemLib_ContentPanel(this);

        setJMenuBar(menuBar);

        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
