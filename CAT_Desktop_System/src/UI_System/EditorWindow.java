/**
 * 类名：EditorWindow
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System;

import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import UI_System.EditWin.UI_EditWin_contentPanel;
import UI_System.GeneralWin.UI_JMenuBar;

import javax.swing.*;
import java.awt.*;

public class EditorWindow extends JFrame {
    public UI_EditWin_contentPanel EditWin_contentPanel;

    public static void main(String[] args) {
        CAT_Project project= ProjectManager.GetProject(1);
        ProjectManager.OpenProject(project);
        ProjectManager.TranslateFile(project.GetTranslationFile(0));
        EditorWindow win = new EditorWindow();
    }

    public EditorWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(1000, 650);
        setTitle("编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        EditWin_contentPanel = new UI_EditWin_contentPanel(this);

        //创建顶部菜单栏
        JMenuBar menuBar = new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(EditWin_contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
