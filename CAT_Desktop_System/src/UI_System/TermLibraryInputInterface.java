package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.TermLibInpu.UI_TermLibInputContent;

import javax.swing.*;
import java.awt.*;

public class TermLibraryInputInterface extends JFrame {
    TermLibraryInputInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("记忆库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel = new UI_TermLibInputContent();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
       // ProjectManager.OpenProject(ProjectManager.GetProject(1));
        TermLibraryInputInterface me = new TermLibraryInputInterface();
    }
}
