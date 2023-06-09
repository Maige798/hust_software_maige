/**
 * 类名：TermLibraryWindow
 * 开发人员：王琢玉
 * 实现功能：设计实现术语库管理框架，将和术语库相关的面板汇集到contentPanel上来展示
 */

package UI_System;

import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.TermLibWin.UI_TermLibWin_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class TermLibraryWindow extends JFrame {
    public UI_TermLibWin_ContentPanel contentPanel;
    public JMenuBar menuBar;

    public TermLibraryWindow() {
        setSize(1000, 650);
        setTitle("术语库");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建顶部菜单栏
        menuBar = new UI_JMenuBar();

        contentPanel = new UI_TermLibWin_ContentPanel(this);
        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
