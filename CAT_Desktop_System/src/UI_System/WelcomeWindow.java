/**
 * 类名：WelcomeWindow
 * 开发人员：刘闯
 * 实现功能：创建欢迎界面
 */

package UI_System;
import UI_System.WelcomeWin.UI_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JFrame {

    public WelcomeWindow() {
        init();
    }

    public void init() {
        setSize(350, 400);
        setTitle("计算机辅助翻译桌面系统");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        UI_ContentPanel contentPanel = new UI_ContentPanel();
        contentPanel.frame = this;

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        WelcomeWindow me = new WelcomeWindow();
    }
}
