/**
 * 类名：MemoryLibraryCreateInterface
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.MemoryLibraryCreateWin.UI_MemoryLibraryCreatePanel;

import javax.swing.*;

public class MemoryLibraryCreateInterface extends JFrame {

    public MemoryLibraryCreateInterface() {
        init();
    }

    public void init() {
        setSize(600, 350);
        setTitle("记忆库创建");

        setResizable(false);

        JPanel panel = new UI_MemoryLibraryCreatePanel();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ProjectManager.OpenProject(ProjectManager.GetProject(1));
        MemoryLibraryCreateInterface me = new MemoryLibraryCreateInterface();
    }
}
