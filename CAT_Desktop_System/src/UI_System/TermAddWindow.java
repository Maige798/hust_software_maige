/**
 * 类名：TermAddWindow
 * 开发人员：刘闯
 * 实现功能：创建术语库添加界面
 */

package UI_System;

import UI_System.TermAddWin.UI_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class TermAddWindow extends JFrame {
    public UI_ContentPanel contentPanel;

    public TermAddWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(350, 250);
        setTitle("添加术语");
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        contentPanel = new UI_ContentPanel();

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
