package javaswing;

import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import javaswing.GeneralWin.UI_JMenuBar;
import javaswing.MemLibWin.UI_MemLib_ContentPanel;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class MemoryLibraryWindow extends JFrame {
    //创建顶部菜单栏
    JMenuBar menuBar;


    //创建内容面板
    JPanel ContentPanel;

    public static void main(String[] args) {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\ProjectSystem\\MyProject.catp";
        CAT_Project project= ProjectManager.LoadProject(myFile);
        ProjectManager.OpenProject(project);
        MemoryLibraryWindow windows = new MemoryLibraryWindow();
        windows.setVisible(true);
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
        ContentPanel = new UI_MemLib_ContentPanel();

        setJMenuBar(menuBar);

        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
