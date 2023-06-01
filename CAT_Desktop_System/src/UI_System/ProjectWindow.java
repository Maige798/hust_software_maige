package UI_System;

import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.ProjectWin.UI_ProjectWin_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class ProjectWindow extends JFrame {
    public UI_ProjectWin_ContentPanel ProjectWin_ContentPanel;
    public JMenuBar menuBar;
    public static void main(String[] args) {
        ProjectWindow win = new ProjectWindow();
        win.setVisible(true);
    }

    public ProjectWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        ProjectWin_ContentPanel = new UI_ProjectWin_ContentPanel();

        menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(ProjectWin_ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
