package UI_System.TermLibCre;

import javax.swing.*;
import java.awt.*;

public class UI_TermCreatePanel1 extends JPanel {
    public  JLabel[] labels;
    public TextField[] textFields;
    public JButton[] buttons;
    public JLabel label;
    public JTable table;
    public  JButton[] buttons2;
    public JTextField textField;
    public UI_TermCreatePanel1()
    {
        this.setLayout(null);

        //创建三对标签文本框并设置位置
        labels=new JLabel[]{new JLabel("术语库名称"),new JLabel("存储路径"),new JLabel("语言")};
        textFields=new TextField[]{new TextField(),new TextField(),new TextField()};
        buttons=new JButton[]{new JButton("浏览"),new JButton("添加")};

        for(int i=0;i<3;i++)
        {
            this.add(labels[i]);
            labels[i].setBounds(50,30+100*i,100,50);
            this.add(textFields[i]);
            textFields[i].setBounds(50,30+50+100*i,350,40);
        }
        for(int i=0;i<2;i++)
        {
            this.add(buttons[i]);
            buttons[i].setBounds(50+350+10,30+50*3+100*i,100,40);
        }

//第二部分
        label=new JLabel("已添加语言");
        this.add(label);
        label.setBounds(50,350,100,50);

        //列表
       table=new JTable(5,1);
        //设置表的行列格式
        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setWidth(350);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(350, 150));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50,400,350,150);

        // 添加 滚动面板 到 内容面板
        this.add(scrollPane);

        //最下方按钮
        buttons2=new JButton[]{new JButton("上一页"),new JButton("下一页"),new JButton("删除"),new JButton("完成创建")};

        textField=new JTextField("1/5");

        for(int i=0;i<2;i++)
        {
            this.add(buttons2[i]);
            // btn.setMargin(new Insets(0,0,0,0));
            buttons2[i].setMargin(new Insets(0,0,0,0));

            buttons2[i].setBounds(50+130*i,550,70,40);
        }
        this.add(textField);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBounds(125,555,50,30);

        this.add(buttons2[2]);
        buttons2[2].setBounds(50+200+40,555,80,40);

        this.add(buttons2[3]);
        buttons2[3].setBounds(50+200+40+80+120,560,100,40);
    }
}
