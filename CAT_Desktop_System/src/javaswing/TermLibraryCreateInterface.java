package javaswing;

import javax.swing.*;
import java.awt.*;
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
        setSize(600, 700);
        setTitle("术语库创建");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建上方文本框
        JPanel panel1=createPanel1();

        //创建下方列表区域
        //   JPanel panel2=createPanel2();


        //创建内容区域
//        Panel ContentPanel = new Panel();
//        ContentPanel.setLayout(null);

        //  ContentPanel.add(panel1);
        //  ContentPanel.add(panel2);

        //   panel1.setBounds(0,0,600,700);//记得给panel设置坐标和宽高才能显示
        //panel2.setBounds(0,330,600,280);

//        setContentPane(ContentPanel);
        setContentPane(panel1);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    public  JPanel createPanel1()
    {
        JPanel panel1=new JPanel();
        // panel1.setBackground(Color.blue);
        panel1.setLayout(null);

        //创建三对标签文本框并设置位置
        JLabel[] labels=new JLabel[]{new JLabel("术语库名称"),new JLabel("存储路径"),new JLabel("语言")};
        TextField[] textFields=new TextField[]{new TextField(),new TextField(),new TextField()};
        JButton[] buttons=new JButton[]{new JButton("浏览"),new JButton("添加")};

        for(int i=0;i<3;i++)
        {
            panel1.add(labels[i]);
            labels[i].setBounds(50,30+100*i,100,50);
            panel1.add(textFields[i]);
            textFields[i].setBounds(50,30+50+100*i,350,40);
        }
        for(int i=0;i<2;i++)
        {
            panel1.add(buttons[i]);
            buttons[i].setBounds(50+350+10,30+50*3+100*i,100,40);
        }

//第二部分
        JLabel label=new JLabel("已添加语言");
        panel1.add(label);
        label.setBounds(50,350,100,50);

        //列表
        JTable table=new JTable(5,1);
        //设置表的行列格式
        table.setRowHeight(30);

        table.getColumnModel().getColumn(0).setWidth(350);

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(350, 150));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50,400,350,150);

        // 添加 滚动面板 到 内容面板
        panel1.add(scrollPane);

        //最下方按钮
        JButton[] buttons2=new JButton[]{new JButton("上一页"),new JButton("下一页"),new JButton("删除"),new JButton("完成创建")};

        JTextField textField=new JTextField("1/5");

        for(int i=0;i<2;i++)
        {
            panel1.add(buttons2[i]);
            // btn.setMargin(new Insets(0,0,0,0));
            buttons2[i].setMargin(new Insets(0,0,0,0));

            buttons2[i].setBounds(50+130*i,550,70,40);
        }
        panel1.add(textField);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBounds(125,555,50,30);

        panel1.add(buttons2[2]);
        buttons2[2].setBounds(50+200+40,555,80,40);

        panel1.add(buttons2[3]);
        buttons2[3].setBounds(50+200+40+80+120,560,100,40);


        return panel1;
    }

//    public JPanel createPanel2()
//    {
//        JPanel panel2=new JPanel();
//        panel2.setLayout(null);
//
//        //panel2.setBackground(Color.BLUE);
//
//        //标签
//        JLabel label=new JLabel("已添加语言");
//        panel2.add(label);
//        label.setBounds(50,350,100,50);
//
//        //列表
//        JTable table=new JTable(5,1);
//        //设置表的行列格式
//        table.setRowHeight(30);
//
//        table.getColumnModel().getColumn(0).setWidth(350);
//
//        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
//        table.setPreferredScrollableViewportSize(new Dimension(350, 150));
//
//        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBounds(50,400,350,150);
//
//        // 添加 滚动面板 到 内容面板
//        panel2.add(scrollPane);
//
//        //最下方按钮
//        JButton[] buttons=new JButton[]{new JButton("上一页"),new JButton("下一页"),new JButton("删除"),new JButton("完成创建")};
//
//        TextField textField=new TextField("1/5");
//
//        for(int i=0;i<2;i++)
//        {
//            panel2.add(buttons[i]);
//            buttons[i].setBounds(50+130*i,550,70,40);
//        }
//        panel2.add(textField);
//        textField.setBounds(125,555,50,30);
//
//        panel2.add(buttons[2]);
//        buttons[2].setBounds(50+200+40,555,80,40);
//
//        panel2.add(buttons[3]);
//        buttons[3].setBounds(50+200+40+80+120,560,100,40);
//
//        return panel2;
//    }


    public static void main(String[] args) {
        TermLibraryCreateInterface me=new TermLibraryCreateInterface();
    }

}
