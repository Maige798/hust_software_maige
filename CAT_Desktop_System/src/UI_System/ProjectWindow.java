/**
 * 类名：ProjectWindow
 * 开发人员：王琢玉
 * 实现功能：设计实现项目管理框架，将和项目相关的面板汇集到contentPanel上来展示
 */

package UI_System;

import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.ProjectWin.UI_ProjectWin_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class ProjectWindow extends JFrame {
    public UI_ProjectWin_ContentPanel ProjectWin_ContentPanel;
    public JMenuBar menuBar;

    public ProjectWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("项目选择");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        ProjectWin_ContentPanel = new UI_ProjectWin_ContentPanel(this);

        menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(ProjectWin_ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
