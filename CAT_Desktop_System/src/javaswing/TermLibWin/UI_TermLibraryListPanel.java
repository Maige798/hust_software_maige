package javaswing.TermLibWin;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class UI_TermLibraryListPanel extends JPanel {
    public JLabel label;
    public JList<String> list;
    public JButton[] changePage;

    public UI_TermLibraryListPanel() {
        setLayout(null);
        setBackground(Color.yellow);

        label = new JLabel("创建术语库列表");
        label.setBounds(25, 50, 100, 50);
        add(label);

        // 创建一个 JList 实例
        list = new JList<String>();

        //设置坐标
        list.setBounds(25, 100, 150, 200);

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
        add(list);

        //添加换页按钮
        changePage = new JButton[]{new JButton("上一页"), new JButton("下一页")};
        //给换页按钮设置坐标
        changePage[0].setBounds(25, 350, 50, 25);
        changePage[1].setBounds(125, 350, 50, 25);
        //添加按钮
        changePage[0].setMargin(new Insets(0, 0, 0, 0));
        changePage[1].setMargin(new Insets(0, 0, 0, 0));
        add(changePage[0]);
        add(changePage[1]);
    }
}
