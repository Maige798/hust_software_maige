/**
 * 类名：MemoryLibraryWindow
 * 开发人员：王琢玉
 * 实现功能：设计实现记忆库管理框架，将和记忆库相关的面板汇集到contentPanel上来展示
 */

package UI_System;

import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.MemLibWin.UI_MemLib_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class MemoryLibraryWindow extends JFrame {
    //创建顶部菜单栏
    public JMenuBar menuBar;


    //创建内容面板
    public JPanel ContentPanel;

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
