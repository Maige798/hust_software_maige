package UI_System;

import UI_System.MemoryLibraryImportInterWin.UI_MemoryLibraryImportPanel;

import javax.swing.*;
import java.awt.*;

public class MemoryLibraryImportInterface extends JFrame {
    MemoryLibraryImportInterface()
    {
        init();
    }

    public void init()
    {
        //窗口设置
        setSize(500,350);
        setTitle("记忆库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel=new UI_MemoryLibraryImportPanel();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
