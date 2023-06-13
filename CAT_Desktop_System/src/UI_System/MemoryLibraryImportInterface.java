/**
 * 类名：MemoryLibraryImportInterface
 * 开发人员：刘闯
 * 实现功能：创建记忆库导入界面
 */

package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.MemoryLibraryImportInterWin.UI_MemoryLibraryImportPanel;

import javax.swing.*;
import java.awt.*;

public class MemoryLibraryImportInterface extends JFrame {
    public MemoryLibraryImportInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("记忆库导入");

        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel = new UI_MemoryLibraryImportPanel();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ProjectManager.OpenProject(ProjectManager.GetProject(1));
        MemoryLibraryImportInterface me = new MemoryLibraryImportInterface();
    }
}
