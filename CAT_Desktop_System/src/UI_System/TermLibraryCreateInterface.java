/**
 * TermLibraryCreateInterface
 * 开发人员：刘闯
 * 实现功能：创建术语库创建界面
 */

package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.TermLibCreate.UI_TermCreatePanel;

import javax.swing.*;

public class TermLibraryCreateInterface extends JFrame {
    public TermLibraryInputInterface inputInterface;

    public TermLibraryCreateInterface(TermLibraryInputInterface inputInterface) {
        this.inputInterface = inputInterface;
        init();
    }

    public void init() {
        setSize(500, 300);
        setTitle("术语库创建");

        setResizable(false);

        //创建上方文本框
        JPanel panel1 = new UI_TermCreatePanel(this);

        setContentPane(panel1);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
