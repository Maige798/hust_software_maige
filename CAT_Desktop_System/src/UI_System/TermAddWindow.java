package UI_System;

import javax.swing.*;
import java.awt.*;
import UI_System.TermAddWin.UI_ContentPanel;

public class TermAddWindow extends JFrame {
    public UI_ContentPanel contentPanel;

    public TermAddWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(350, 250);
        setTitle("术语添加");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        contentPanel = new UI_ContentPanel();

        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TermAddWindow me = new TermAddWindow();
    }
}
