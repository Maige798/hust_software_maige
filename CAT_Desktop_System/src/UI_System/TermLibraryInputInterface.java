package UI_System;

import UI_System.TermLibInput.UI_ContentPanel;

import javax.swing.*;

public class TermLibraryInputInterface extends JFrame {
    //创建。。。宽200，高50，x:100,y:50(一个导航栏高）
    //表格：单元格宽300，高25
    //按钮：宽50，高25，x：100+200，y:50+50+25*3+20 ，x:100+300+50,y:（中间宽度两个单元格高）
    public TermLibraryInputInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(800, 500);
        setTitle("术语库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建内容面板
        JPanel ContentPanel = new UI_ContentPanel();

        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TermLibraryInputInterface me = new TermLibraryInputInterface();
    }
}
