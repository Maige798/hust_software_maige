package UI_System.TermLibInput;

import javax.swing.*;
import java.awt.*;

public class UI_CreatePanel4 extends JPanel {
    JTable table;
    public UI_CreatePanel4()
    {
        //设置表头并创建表格
        String[] tableHead=new String[]{"项目语言","所选术语库中已映射语言"};
        Object[][] rowData={{"junit","Crusader Kings"},
                {"lcwzy","Celestial orbit"}
               };

        table=new JTable(rowData,tableHead);

        //设置单元格行高列宽
        table.setRowHeight(25);
        for(int i=0;i<2;i++)
        {
            table.getColumnModel().getColumn(i).setWidth(300);
        }

        // 设置表格内容颜色
        table.setForeground(Color.BLUE);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        //设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(600, 75));

        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加 滚动面板 到 内容面板
        this.add(scrollPane);
    }
}
