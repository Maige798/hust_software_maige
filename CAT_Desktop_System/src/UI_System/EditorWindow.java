/**
 * 类名：EditorWindow
 * 开发人员：王琢玉
 * 实现功能：设计实现编辑窗口框架，将和编辑器相关的四个独立的面板汇集到contentPanel上来展示
 */

package UI_System;

import UI_System.EditWin.UI_EditWin_contentPanel;
import UI_System.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    public UI_EditWin_contentPanel EditWin_contentPanel;

    public EditorWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        EditWin_contentPanel = new UI_EditWin_contentPanel(this);

        //创建顶部菜单栏
        JMenuBar menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(EditWin_contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
