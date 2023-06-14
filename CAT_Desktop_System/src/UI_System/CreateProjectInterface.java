/**
 * 类名：CreateProjectInterface
 * 开发人员：刘闯
 * 实现功能：创建创建项目界面
 */

package UI_System;

import UI_System.CreateProject.UI_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class CreateProjectInterface extends JFrame {
    public CreateProjectInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(750, 480);
        setTitle("创建项目");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        UI_ContentPanel contentPanel = new UI_ContentPanel(this);

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
