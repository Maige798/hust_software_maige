package javaswing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

        //创建顶部菜单栏
        JMenuBar menuBar=createJMenuBar();

        //创建项目信息栏
        JPanel ProjectInformationPanel=createProjectInformationPanel();

        //创建主界面切换栏
        JPanel InterfaceSwitchingPanel=createInterfaceSwitchingPanel();

        //创建翻译面板
        JPanel EditPanel = createEditPanel();

        //创建记忆库面板
        JPanel MemoryLibraryPanel = createMemoryLibraryPanel();

        //创建术语库面板
        JPanel TermLibraryPanel = createTermLibraryPanel();

        //创建内容面板
        JPanel ContentPanel = new JPanel();
        setJMenuBar(menuBar);
        ContentPanel.setLayout(null);
        ContentPanel.add(EditPanel);
        ContentPanel.add(MemoryLibraryPanel);
        ContentPanel.add(TermLibraryPanel);
        ContentPanel.add(ProjectInformationPanel);
        ContentPanel.add(InterfaceSwitchingPanel);
        EditPanel.setBounds(200,180,800,450);
        MemoryLibraryPanel.setBounds(200,0,500,200);
        TermLibraryPanel.setBounds(700,0,300,200);
        ProjectInformationPanel.setBounds(0,0,200,400);
        InterfaceSwitchingPanel.setBounds(0,400,200,250);
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
        bookPrint.setForeground(Color.BLACK);

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

        int yBegin = 55;
        for(int i=0;i<states.length;i++)
        {
            states[i].setBounds(390,yBegin+i*40,30,30);
        }

        int yFirst =55;
        int ySecond = 55;
        for(int i=0;i<texts.length;i+=2)
        {
            texts[i].setBounds(45,yFirst+i*20,320,30);
            texts[i].setEditable(false);
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

        JPanel panel = new JPanel();
        panel.setLayout(null);
        Color PinkColor = new Color(219,141,241);
        panel.setBackground(PinkColor);

        JTextArea textArea = new JTextArea();
        Color BlueColor = new Color(140,240,240);
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        JButton jButton = new JButton("应用翻译结果");

        panel.add(textArea);
        panel.add(jButton);

        textArea.setBounds(20,15,460,130);
        jButton.setBounds(360,150,120,20);

        return panel;
    }

    private JPanel createTermLibraryPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Color DarkBlueColor = new Color(47,116,208);
        panel.setBackground(DarkBlueColor);

        JTextArea textArea = new JTextArea();
        Color BlueColor = new Color(140,240,240);
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        JButton jButton = new JButton("添加术语");

        panel.add(textArea);
        panel.add(jButton);

        textArea.setBounds(20,15,250,130);
        jButton.setBounds(180,150,90,20);

        return panel;
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

    public JPanel createProjectInformationPanel() {
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
}