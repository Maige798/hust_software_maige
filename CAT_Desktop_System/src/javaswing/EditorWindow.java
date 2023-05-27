package javaswing;

import javaswing.EditWin.UI_EditWin_contentPanel;
import javaswing.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorWindow extends JFrame {
    public UI_EditWin_contentPanel EditWin_contentPanel;
    public static void main(String[] args) {
        EditorWindow win = new EditorWindow();
        win.setVisible(true);
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