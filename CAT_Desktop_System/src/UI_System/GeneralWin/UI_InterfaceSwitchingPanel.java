package UI_System.GeneralWin;

import javax.swing.*;
import java.awt.*;

public class UI_InterfaceSwitchingPanel extends JPanel {
    public JList<String> list2;

    public UI_InterfaceSwitchingPanel() {

        list2 = new JList<>();

        // 设置一下首选大小
        list2.setPreferredSize(new Dimension(200, 250));

        // 允许可间断的多选
        list2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 设置选项数据（内部将自动封装成 ListModel ）
        list2.setListData(new String[]{"项目", "文件", "编辑器", "翻译记忆库", "术语库"});

        //设置单元格大小
        list2.setFixedCellWidth(200);
        list2.setFixedCellHeight(35);

        //设置单元格文字居中
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        list2.setCellRenderer(renderer);

        // 添加选项选中状态被改变的监听器
        list2.addListSelectionListener(e -> {
            // 获取所有被选中的选项索引
            int[] indices = list2.getSelectedIndices();
            // 获取选项数据的 ListModel
            ListModel<String> listModel = list2.getModel();
            // 输出选中的选项
            for (int index : indices) {
                System.out.println("选中: " + index + " = " + listModel.getElementAt(index));
            }
            System.out.println();
        });

        // 设置默认选中项
        list2.setSelectedIndex(1);

        //将list2添加到panel2中
        add(list2);
    }
}
