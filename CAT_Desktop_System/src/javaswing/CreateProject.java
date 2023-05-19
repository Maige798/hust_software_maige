package javaswing;

import javax.swing.*;
import java.awt.*;

public class CreateProject {
    public static void init() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);


        JPanel panel=new JPanel();
        panel.setLayout(null);
        frame.setContentPane(panel);

        //基本组件
        JLabel alabel=new JLabel("项目名称");
        JLabel blabel=new JLabel("位置路径");
        JLabel clabel=new JLabel("项目文件");
        JLabel dlabel=new JLabel("源语言");
        JLabel elabel=new JLabel("目标语言");

        TextField aText=new TextField(8);
        aText.setFont(new Font(null,Font.PLAIN,20));
        TextField bText=new TextField(8);
        bText.setFont(new Font(null,Font.PLAIN,20));


        JButton aButton=new JButton("创建");
        JButton bButton=new JButton("浏览");
        JButton cButton=new JButton("上一页");
        JButton dButton=new JButton("下一页");

        JMenuBar menuBar=new JMenuBar();
        JMenu importFile=new JMenu("导入文件");
        JMenu deleteFile=new JMenu("删除文件");
        menuBar.add(importFile);
        menuBar.add(deleteFile);

        JList list=new JList<>();

//        String[] listData=new String[]{"English","Chinese"};
//        JComboBox<String> comboBox=new JComboBox<String>(listData);
//        comboBox.setSelectedIndex(2);
        //布局
//左上角
        panel.add(alabel);
        panel.add(blabel);
        panel.add(aText);
        panel.add(bText);
        panel.add(aButton);
        panel.add(bButton);
        alabel.setBounds(0,0,20,25);
        blabel.setBounds(0,50,20,25);
        aText.setBounds(0,25,100,25);
        bText.setBounds(0,75,100,25);
        aButton.setBounds(100,25,50,25);
        aButton.setBounds(100,75,50,25);



        frame.setVisible(true);

    }

    public static void main(String[] args) {
        init();
    }
}
