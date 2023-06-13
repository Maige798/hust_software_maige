/**
 * 类名：MemoryLibraryCreateInterface
 * 开发人员：刘闯
 * 实现功能：创建记忆库创建界面
 */

package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.MemoryLibraryCreateWin.UI_MemoryLibraryCreatePanel;

import javax.swing.*;

public class MemoryLibraryCreateInterface extends JFrame {
    public MemoryLibraryImportInterface importInterface;

    public MemoryLibraryCreateInterface(MemoryLibraryImportInterface importInterface) {
        this.importInterface=importInterface;
        init();
    }

    public void init() {
        setSize(600, 350);
        setTitle("记忆库创建");

        setResizable(false);

        JPanel panel = new UI_MemoryLibraryCreatePanel(this);

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
