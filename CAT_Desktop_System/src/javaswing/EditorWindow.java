package javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorWindow extends JFrame{
    public static void main(String[] args){
        EditorWindow win = new EditorWindow();
        win.setVisible(true);
    }

    public EditorWindow(){
        init();
    }

    private void init(){
        //窗口设置
        setSize(1000,650);
        setTitle("编辑器");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建翻译面板
        JPanel EditPanel = createEditPanel();

        //创建记忆库面板
        JPanel MemoryLibraryPanel=createMemoryLibraryPanel();

        //创建内容面板
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.add(EditPanel);
        EditPanel.setBounds(200,200,800,450);


        setContentPane(ContentPanel);
        setLocationRelativeTo(null);

    }
    private JPanel createEditPanel(){
        JLabel editLabels0 = new JLabel("原文");
        editLabels0.setForeground(Color.BLACK);
        JLabel editLabels1 = new JLabel("状态");
        editLabels1.setForeground(Color.BLACK);
        JLabel editLabels2 = new JLabel("译文");
        editLabels2.setForeground(Color.BLACK);
        JLabel bookPrint = new JLabel("?/?");
        editLabels2.setForeground(Color.BLACK);

        JLabel status1 = new JLabel("*");
        status1.setForeground(Color.BLACK);
        status1.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status2 = new JLabel("*");
        status2.setForeground(Color.BLACK);
        status2.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status3 = new JLabel("*");
        status3.setForeground(Color.BLACK);
        status3.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status4 = new JLabel("*");
        status4.setForeground(Color.BLACK);
        status4.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status5 = new JLabel("*");
        status5.setForeground(Color.BLACK);
        status5.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status6 = new JLabel("*");
        status6.setForeground(Color.BLACK);
        status6.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status7 = new JLabel("*");
        status7.setForeground(Color.BLACK);
        status7.setFont(new Font("宋体", Font.BOLD, 15));
        JLabel status8 = new JLabel("*");
        status8.setForeground(Color.BLACK);
        status8.setFont(new Font("宋体", Font.BOLD, 15));

        TextField text1=new TextField(8);
        text1.setFont(new Font(null,Font.PLAIN,20));
        TextField text2=new TextField(8);
        text2.setFont(new Font(null,Font.PLAIN,20));
        TextField text3=new TextField(8);
        text3.setFont(new Font(null,Font.PLAIN,20));
        TextField text4=new TextField(8);
        text4.setFont(new Font(null,Font.PLAIN,20));
        TextField text5=new TextField(8);
        text5.setFont(new Font(null,Font.PLAIN,20));
        TextField text6=new TextField(8);
        text6.setFont(new Font(null,Font.PLAIN,20));
        TextField text7=new TextField(8);
        text7.setFont(new Font(null,Font.PLAIN,20));
        TextField text8=new TextField(8);
        text8.setFont(new Font(null,Font.PLAIN,20));
        TextField text9=new TextField(8);
        text9.setFont(new Font(null,Font.PLAIN,20));
        TextField text10=new TextField(8);
        text10.setFont(new Font(null,Font.PLAIN,20));
        TextField text11=new TextField(8);
        text11.setFont(new Font(null,Font.PLAIN,20));
        TextField text12=new TextField(8);
        text12.setFont(new Font(null,Font.PLAIN,20));
        TextField text13=new TextField(8);
        text13.setFont(new Font(null,Font.PLAIN,20));
        TextField text14=new TextField(8);
        text14.setFont(new Font(null,Font.PLAIN,20));
        TextField text15=new TextField(8);
        text15.setFont(new Font(null,Font.PLAIN,20));
        TextField text16=new TextField(8);
        text16.setFont(new Font(null,Font.PLAIN,20));


        JButton btn1 = new JButton("确认翻译");
        JButton btn2 = new JButton("开始机械翻译");
        JButton btn3 = new JButton("上一页");
        JButton btn4 = new JButton("下一页");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        Color BlueColor = new Color(128,255,255);
        panel.setBackground(BlueColor);

        panel.add(editLabels0);
        panel.add(editLabels1);
        panel.add(editLabels2);
        panel.add(bookPrint);
        panel.add(status1);
        panel.add(status2);
        panel.add(status3);
        panel.add(status4);
        panel.add(status5);
        panel.add(status6);
        panel.add(status7);
        panel.add(status8);


        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(text7);
        panel.add(text8);
        panel.add(text9);
        panel.add(text10);
        panel.add(text11);
        panel.add(text12);
        panel.add(text13);
        panel.add(text14);
        panel.add(text15);
        panel.add(text16);

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);

        editLabels0.setBounds(45,10,300,30);
        editLabels1.setBounds(380,10,30,30);
        editLabels2.setBounds(435,10,30,30);
        bookPrint.setBounds(620,380,40,20);

        status1.setBounds(390,45,30,30);
        status2.setBounds(390,85,30,30);
        status3.setBounds(390,125,30,30);
        status4.setBounds(390,165,30,30);
        status5.setBounds(390,205,30,30);
        status6.setBounds(390,245,30,30);
        status7.setBounds(390,285,30,30);
        status8.setBounds(390,325,30,30);

        text1.setBounds(45,45,320,30);
        text2.setBounds(415,45,320,30);
        text3.setBounds(45,85,320,30);
        text4.setBounds(415,85,320,30);
        text5.setBounds(45,125,320,30);
        text6.setBounds(415,125,320,30);
        text7.setBounds(45,165,320,30);
        text8.setBounds(415,165,320,30);
        text9.setBounds(45,205,320,30);
        text10.setBounds(415,205,320,30);
        text11.setBounds(45,245,320,30);
        text12.setBounds(415,245,320,30);
        text13.setBounds(45,285,320,30);
        text14.setBounds(415,285,320,30);
        text15.setBounds(45,325,320,30);
        text16.setBounds(415,325,320,30);

        btn1.setBounds(485,15,100,20);
        btn2.setBounds(605,15,130,20);
        btn3.setBounds(505,380,90,20);
        btn4.setBounds(665,380,90,20);


        return panel;
    }

    private JPanel createMemoryLibraryPanel(){
    return null;
    }

}
