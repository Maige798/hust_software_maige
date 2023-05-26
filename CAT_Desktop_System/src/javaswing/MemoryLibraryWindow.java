package javaswing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class MemoryLibraryWindow extends JFrame {
    public static void main(String[] args){
        MemoryLibraryWindow windows = new MemoryLibraryWindow();
        windows.setVisible(true);
    }
    public MemoryLibraryWindow()
    {
        init();
    }

    public void init()
    {
        //窗口设置
        setSize(1000,650);
        setTitle("翻译记忆库");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建顶部菜单栏
        JMenuBar menuBar=createJMenuBar();

        //创建翻译记忆库列表
        JPanel MemoryLibraryListPanel=createMemoryLibraryListPanel();

        //创建主界面切换栏
        JPanel InterfaceSwitchingPanel=createInterfaceSwitchingPanel();

        //创建记忆库条目栏
        JPanel MemoryLibraryItemsPanel = createMemoryLibraryItemsPanel();

        //创建条目筛选栏
        JPanel ItemSelectionPanel = createItemSelectionPanel();

        //创建内容面板
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(null);

        setJMenuBar(menuBar);
        ContentPanel.add(MemoryLibraryListPanel);
        ContentPanel.add(InterfaceSwitchingPanel);
        ContentPanel.add(MemoryLibraryItemsPanel);
        ContentPanel.add(ItemSelectionPanel);

        MemoryLibraryListPanel.setBounds(0,0,200,400);
        InterfaceSwitchingPanel.setBounds(0,400,200,250);
        MemoryLibraryItemsPanel.setBounds(200,100,800,500);
        ItemSelectionPanel.setBounds(200,0,800,150);

        setContentPane(ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JMenuBar createJMenuBar() {
        JMenuBar menuBar=new JMenuBar();

        JMenu menu1=new JMenu("文件");
        JMenu menu2=new JMenu("菜单");
        JMenu menu3=new JMenu("项目");
        JMenu menu4=new JMenu("选项四");
        JMenu menu5=new JMenu("选项五");
        JMenu menu6=new JMenu("选项六");

        JMenuItem item1=new JMenuItem("译文另存为");
        JMenuItem item2=new JMenuItem("保存");
        JMenuItem item3=new JMenuItem("关闭");

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        menuBar.add(menu6);



        return menuBar;
    }

    public JPanel createMemoryLibraryListPanel() {
        JPanel panel1=new JPanel();
        panel1.setLayout(null);

        panel1.setBackground(Color.yellow);

        JLabel label=new JLabel("创建记忆库列表");
        label.setBounds(25,50,100,50);
        panel1.add(label);

        //创建列表

        // 创建一个 JList 实例
        JList<String> list = new JList<String>();

        //设置坐标
        list.setBounds(25,100,150,200);

        // 设置一下首选大小
        //list.setPreferredSize(new Dimension(200, 300));

        // 允许可间断的多选
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 设置选项数据（内部将自动封装成 ListModel ）
        list.setListData(new String[]{"香蕉", "雪梨", "苹果", "荔枝"});

        // 添加选项选中状态被改变的监听器
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = list.getSelectedIndices();
                // 获取选项数据的 ListModel
                ListModel<String> listModel = list.getModel();
                // 输出选中的选项
                for (int index : indices) {
                    System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
                }
                System.out.println();
            }
        });

        // 设置默认选中项
        list.setSelectedIndex(1);

        // 添加到内容面板容器
        panel1.add(list);

        //添加换页按钮
        JButton[] changePage=new JButton[]{new JButton("上一页"),new JButton("下一页")};
        //给换页按钮设置坐标
        changePage[0].setBounds(25,350,50,25);
        changePage[1].setBounds(125,350,50,25);
        //添加按钮
        changePage[0].setMargin(new Insets(0,0,0,0));
        changePage[1].setMargin(new Insets(0,0,0,0));
        panel1.add(changePage[0]);
        panel1.add(changePage[1]);

        return panel1;
    }

    public JPanel createInterfaceSwitchingPanel() {
        JPanel panel2=new JPanel();
        //panel2.setLayout(null);

        //panel2.setBackground(Color.blue);
        //创建列表

        // 创建一个 JList 实例
        JList<String> list2 = new JList<String>();

        //设置坐标
        //list2.setBounds(0,400,200,250);
        // System.out.println("i am here");

        // 设置一下首选大小
        list2.setPreferredSize(new Dimension(200, 250));

        // 允许可间断的多选
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 设置选项数据（内部将自动封装成 ListModel ）
        list2.setListData(new String[]{"项目", "文件", "编辑器", "翻译记忆库","术语库"});

        //设置单元格大小
        list2.setFixedCellWidth(200);
        list2.setFixedCellHeight(35);

        //设置单元格文字居中
        DefaultListCellRenderer renderer=new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        list2.setCellRenderer(renderer);

        // 添加选项选中状态被改变的监听器
        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // 获取所有被选中的选项索引
                int[] indices = list2.getSelectedIndices();
                // 获取选项数据的 ListModel
                ListModel<String> listModel = list2.getModel();
                // 输出选中的选项
                for (int index : indices) {
                    System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
                }
                System.out.println();
            }
        });

        // 设置默认选中项
        list2.setSelectedIndex(1);

        //将list2添加到panel2中
        panel2.add(list2);

        return panel2;
    }

    public JPanel createMemoryLibraryItemsPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Color Green = new Color(204,255,128);
        panel.setBackground(Green);

        JLabel label = new JLabel("记忆库条目");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        Color Blue = new Color(64,0,128);
        label.setForeground(Blue);
        JLabel bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        JTable table = new JTable(18,2);
        table.setRowHeight(21);
        table.setGridColor(new Color(192,192,192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton btn1 = new JButton("标记删除");
        JButton btn2 = new JButton("取消更改");
        JButton btn3 = new JButton("保存更改");
        JButton formerPage = new JButton("上一页");
        JButton nextPage = new JButton("下一页");

        panel.add(label);
        panel.add(bookPrint);
        panel.add(table);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(formerPage);
        panel.add(nextPage);

        label.setBounds(10,5,200,40);
        bookPrint.setBounds(660,450,40,20);
        table.setBounds(30,50,740,378);
        formerPage.setBounds(570,450,80,20);
        nextPage.setBounds(690,450,80,20);
        btn1.setBounds(200,450,90,20);
        btn2.setBounds(310,450,90,20);
        btn3.setBounds(420,450,90,20);

        return panel;
    }

    public JPanel createItemSelectionPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Color Orange = new Color(246, 154, 113);
        panel.setBackground(Orange);

        JLabel label = new JLabel("条目筛选");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        Color Blue = new Color(64,0,128);
        label.setForeground(Blue);

        JLabel origin = new JLabel("原文文本");
        origin.setForeground(Color.BLACK);
        origin.setFont(new Font("思源黑体", Font.BOLD, 20));
        JLabel translation = new JLabel("译文文本");
        translation.setForeground(Color.BLACK);
        translation.setFont(new Font("思源黑体", Font.BOLD, 20));

        JTextField field1 = new JTextField(8);
        field1.setFont(new Font(null,Font.PLAIN,20));
        JTextField field2 = new JTextField(8);
        field2.setFont(new Font(null,Font.PLAIN,20));

        JButton selectButton = new JButton("筛选");

        panel.add(label);
        panel.add(origin);
        panel.add(translation);
        panel.add(field1);
        panel.add(field2);
        panel.add(selectButton);

        label.setBounds(10,0,200,30);
        origin.setBounds(70,30,100,32);
        field1.setBounds(70,65,250,25);
        translation.setBounds(360,30,100,32);
        field2.setBounds(360,65,250,25);
        selectButton.setBounds(650,40,100,30);

        return panel;
    }
}