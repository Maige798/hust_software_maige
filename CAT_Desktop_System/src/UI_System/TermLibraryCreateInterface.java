package UI_System;

import ProjectSystem.ProjectManager;
import UI_System.TermLibCreate.UI_TermCreatePanel1;

import javax.swing.*;

public class TermLibraryCreateInterface extends JFrame {
    //左右侧边框50，上下边框30
    //上方文本框区域：标签：宽100高50
    //文本框：宽350高50   按钮：宽100高50

    //下方列表区域：标签：宽100高50 x:50 y:30+(50+50)*3
    //列表：列宽450 行高30 五行
    //下方按钮：

    public TermLibraryCreateInterface() {
        init();
    }

    public void init() {
        setSize(500, 300);
        setTitle("术语库创建");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建上方文本框
        JPanel panel1 = new UI_TermCreatePanel1();

        setContentPane(panel1);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        ProjectManager.OpenProject(ProjectManager.GetProject(1));
        TermLibraryCreateInterface me = new TermLibraryCreateInterface();
    }
}
