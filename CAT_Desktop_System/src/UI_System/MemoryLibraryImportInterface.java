/**
 * 类名：MemoryLibraryImportInterface
 * 开发人员：刘闯
 * 实现功能：创建记忆库导入界面
 */

package UI_System;

import UI_System.MemoryLibraryImportInterWin.UI_MemoryLibraryImportPanel;

import javax.swing.*;
import java.awt.*;

public class MemoryLibraryImportInterface extends JFrame {
    public UI_MemoryLibraryImportPanel panel;

    public MemoryLibraryImportInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("记忆库导入");

        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        panel = new UI_MemoryLibraryImportPanel(this);

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
