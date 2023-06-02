package UI_System;

import UI_System.EditWin.UI_EditWin_contentPanel;
import UI_System.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    public UI_EditWin_contentPanel EditWin_contentPanel;

    public static void main(String[] args) {
        EditorWindow win = new EditorWindow();
    }

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

        EditWin_contentPanel = new UI_EditWin_contentPanel();

        //创建顶部菜单栏
        JMenuBar menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(EditWin_contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
