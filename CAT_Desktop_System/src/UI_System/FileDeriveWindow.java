package UI_System;

import UI_System.FileDeriveWin.UI_FileDerivePanel;

import javax.swing.*;
import java.awt.*;

public class FileDeriveWindow extends JFrame {
    public FileDeriveWindow() {
        init();
    }

    public void init() {
        setSize(520, 350);
        setTitle("文件界面");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel = new UI_FileDerivePanel(this);

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        FileDeriveWindow me = new FileDeriveWindow();
    }
}
