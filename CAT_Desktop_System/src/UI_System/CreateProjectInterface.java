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
        setTitle("记忆库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        JPanel contentPanel = new UI_ContentPanel();

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        CreateProjectInterface me = new CreateProjectInterface();
    }
}
