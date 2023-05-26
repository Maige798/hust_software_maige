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

    public void init(){
        //窗口设置
        setSize(1000,650);
        setTitle("编辑器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建翻译面板
        JPanel EditPanel = createEditPanel();

        //创建记忆库面板
        JPanel MemoryLibraryPanel = createMemoryLibraryPanel();

        //创建术语库面板
        JPanel TermLibraryPanel = createTermLibraryPanel();

        //创建内容面板
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.add(EditPanel);
        EditPanel.setBounds(200,200,800,450);

        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
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

        JLabel[] states = new JLabel[8];
        for(int i=0;i<states.length;i++) {
            states[i] = new JLabel("*");
            states[i].setFont(new Font("宋体", Font.BOLD, 15));
            states[i].setForeground(Color.BLACK);
        }

        TextField[] texts = new TextField[16];
        for(int i=0;i<texts.length;i++) {
            texts[i] =new TextField(8);
            texts[i].setFont(new Font(null,Font.PLAIN,20));
        }

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

        for(JLabel jLabel:states){
            panel.add(jLabel);
        }

        for(TextField textField:texts){
            panel.add(textField);
        }

        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);

        editLabels0.setBounds(45,10,300,30);
        editLabels1.setBounds(380,10,30,30);
        editLabels2.setBounds(435,10,30,30);
        bookPrint.setBounds(620,380,40,20);

        int yBegin = 45;
        for(int i=0;i<states.length;i++)
        {
            states[i].setBounds(390,yBegin+i*40,30,30);
        }

        int yFirst =45;
        int ySecond = 45;
        for(int i=0;i<texts.length;i+=2)
        {
            texts[i].setBounds(45,yFirst+i*20,320,30);
        }
        for(int i=1;i<texts.length;i+=2)
        {
            texts[i].setBounds(415,yFirst+(i-1)*20,320,30);
        }

        btn1.setBounds(485,15,100,20);
        btn2.setBounds(605,15,130,20);
        btn3.setBounds(505,380,90,20);
        btn4.setBounds(665,380,90,20);


        return panel;
    }

    private JPanel createMemoryLibraryPanel(){
        return null;
    }

    private JPanel createTermLibraryPanel(){
        return null;
    }
}
