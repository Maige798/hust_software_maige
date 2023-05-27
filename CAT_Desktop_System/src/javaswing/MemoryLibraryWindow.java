package javaswing;

import javaswing.MemLibWin.UI_MemLib_ContentPanel;
import javaswing.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import java.awt.*;

public class MemoryLibraryWindow extends JFrame {
    //创建顶部菜单栏
    JMenuBar menuBar;
    //创建内容面板
    JPanel ContentPanel;

    public static void main(String[] args) {
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
