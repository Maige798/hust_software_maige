package UI_System.FileSysWin;

import ProjectSystem.ProjectManager;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class UI_FileListPanel extends JPanel {
    public Color Green = new Color(61, 232, 213);
    public Color Blue = new Color(52, 89, 183);

    public static final int tableRow = 12;

    public JLabel label;
    public JLabel bookPrint;
    public JTable table;
    public JButton formerPage;
    public JButton nextPage;

    public UI_FileListPanel() {
        setLayout(null);
        setBackground(Green);

        label = new JLabel("文件列表");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);
        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        table = new JTable(tableRow, 2);
        table.setRowHeight(25);
        table.setGridColor(new Color(192, 192, 192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        TableColumn tableColumn = table.getColumnModel().getColumn(1);
        tableColumn.setPreferredWidth(250);
        table.doLayout();

        formerPage = new JButton("上一页");
        nextPage = new JButton("下一页");

        add(label);
        add(bookPrint);
        add(table);
        add(formerPage);
        add(nextPage);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(615, 370, 40, 20);
        table.setBounds(30, 50, 740, 300);
        formerPage.setBounds(500, 370, 90, 20);
        nextPage.setBounds(655, 370, 90, 20);
    }

    public void UpdateTableItem(){
        for (int i = 0; i < tableRow; i++) {
            table.setValueAt(ProjectManager.instance.currentProject.translationFileList.get(i).name, i, 0);
            table.setValueAt(ProjectManager.instance.currentProject.translationFileList.get(i).save, i, 1);
        }
    }
}
