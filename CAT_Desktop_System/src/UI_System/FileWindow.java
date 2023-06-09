package UI_System;

import UI_System.FileWin.UI_File;

import javax.swing.*;
import java.awt.*;

public class FileWindow extends JFrame {
    public FileWindow()
    {
        init();
    }

    public void init()
    {
        setSize(520, 350);
        setTitle("文件界面");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel = new UI_File();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        FileWindow me=new FileWindow();
    }
}
