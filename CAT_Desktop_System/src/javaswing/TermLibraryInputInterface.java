package javaswing;

import javaswing.TermLibInput.UI_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class TermLibraryInputInterface extends JFrame {
    //创建。。。宽200，高50，x:100,y:50(一个导航栏高）
    //表格：单元格宽300，高25
    //按钮：宽50，高25，x：100+200，y:50+50+25*3+20 ，x:100+300+50,y:（中间宽度两个单元格高）
    public TermLibraryInputInterface()
    {init();}

    public void init()
    {
        //窗口设置
        setSize(800,500);
        setTitle("术语库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建导航栏(三个按钮）
//        JPanel panel1=createPanel1();
//
//        //创建上面的表格
//        JPanel panel2=createPanel2();
//
//        //设置中间两个按钮
//        JPanel panel3=createPanel3();
//
//        //创建下面的表格
//        JPanel panel4=createPanel4();
//
//        //创建最下面的两个按钮
//        JPanel panel5=createPanel3();



        //创建内容面板

        JPanel ContentPanel = new UI_ContentPanel();
//        ContentPanel.setLayout(null);
//        ContentPanel.add(panel1);
//        ContentPanel.add(panel2);
//        ContentPanel.add(panel3);
//        ContentPanel.add(panel4);
//        ContentPanel.add(panel5);
//
//        panel1.setBounds(100,50,600,50);
//
//        panel2.setBounds(100,100,600,75);
//
//        panel3.setBounds(100,175,600,50);
//
//        panel4.setBounds(100,225,600,100);
//
//        panel5.setBounds(100,325,600,50);


        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);



    }

//    public JPanel createPanel1()
//    {
//        JPanel panel1=new JPanel();
//        panel1.setBackground(Color.BLUE);
//        //网格袋布局
//        GridLayout layout=new GridLayout(1,3);
//
//        panel1.setLayout(layout);
//
//        JButton[] buttons=new JButton[]{new JButton("创建"),new JButton("删除"),new JButton("使用")};
//
//
//        for(int i=0;i<3;i++)
//        {
//            panel1.add(buttons[i]);
//        }
//
//
//        return panel1;
//    }
//
//    public JPanel createPanel2()
//    {
//        JPanel panel2 =new JPanel();
//        //  panel2.setLayout(null);
//
//
//
//        //设置表头并创建表格
//        String[] tableHead=new String[]{"术语库名称","已启用"};
//        Object[][] rowData={{"singban","tkf"},
//                {"merge","Appointment for War"}};
//
//        JTable table=new JTable(rowData,tableHead);
//
//        //设置单元格行高列宽
//        table.setRowHeight(25);
//        for(int i=0;i<2;i++)
//        {
//            table.getColumnModel().getColumn(i).setWidth(300);
//        }
//
//        // 设置表格内容颜色
//        table.setForeground(Color.BLUE);                   // 字体颜色
//        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
//        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
//        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
//        table.setGridColor(Color.GRAY);                     // 网格颜色
//
//        //设置表头
//        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
//        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
//        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
//        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
//
//        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
//        table.setPreferredScrollableViewportSize(new Dimension(600, 75));
//
//        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // 添加 滚动面板 到 内容面板
//        panel2.add(scrollPane);
//
//        return panel2;
//    }
//    //jtable要放在滚动面板中才能显示表头以及其他作用
//
//    public JPanel createPanel3()
//    {
//        JPanel panel3=new JPanel();
//        //panel3.setBackground(Color.BLUE);
//        // panel3.setLayout(null);
//
//        JButton[] buttons=new JButton[]{new JButton("上一页"),new JButton("下一页")};
//
////        buttons[0].setBounds(300,195,50,25);
////        buttons[1].setBounds(450,195,50,25);
//
//        for(int i=0;i<2;i++)
//        {
//            panel3.add(buttons[i]);
//        }
//
//        return panel3;
//    }
//    //what,为啥两个按钮没法设置坐标
//
//    public JPanel createPanel4()
//    {
//        JPanel panel4=new JPanel();
//
//        //设置表头并创建表格
//        String[] tableHead=new String[]{"项目语言","所选术语库中已映射语言"};
//        Object[][] rowData={{"junit","Crusader Kings"},
//                {"lcwzy","Celestial orbit"},
//                {"435","csgo"}};
//
//        JTable table=new JTable(rowData,tableHead);
//
//        //设置单元格行高列宽
//        table.setRowHeight(25);
//        for(int i=0;i<2;i++)
//        {
//            table.getColumnModel().getColumn(i).setWidth(300);
//        }
//
//        // 设置表格内容颜色
//        table.setForeground(Color.BLUE);                   // 字体颜色
//        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
//        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
//        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
//        table.setGridColor(Color.GRAY);                     // 网格颜色
//
//        //设置表头
//        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
//        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
//        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
//        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
//
//        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
//        table.setPreferredScrollableViewportSize(new Dimension(600, 75));
//
//        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // 添加 滚动面板 到 内容面板
//        panel4.add(scrollPane);
//
//        return panel4;
//
//    }




    public static void main(String[] args) {
        TermLibraryInputInterface me=new TermLibraryInputInterface();
    }
}
