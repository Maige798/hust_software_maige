/**
 * 类名：TermLibraryWindow
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System;

import UI_System.GeneralWin.UI_JMenuBar;
import UI_System.TermLibWin.UI_TermLibWin_ContentPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TermLibraryWindow extends JFrame {
    public UI_TermLibWin_ContentPanel contentPanel;
    public JMenuBar menuBar;

    public static void main(String[] args) {
        TermLibraryWindow windows = new TermLibraryWindow();
        windows.setVisible(true);
    }

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
