package javaswing;

import javaswing.FileSysWin.UI_FileSysWin_ContentPanel;
import javaswing.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class FileSystemWindow extends JFrame {
    public UI_FileSysWin_ContentPanel FileSysWin_ContentPanel;
    public JMenuBar menuBar;

    public static void main(String[] args) {
        FileSystemWindow win = new FileSystemWindow();
        win.setVisible(true);
    }

    public FileSystemWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        FileSysWin_ContentPanel = new UI_FileSysWin_ContentPanel();

        //创建顶部菜单栏
        menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(FileSysWin_ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
