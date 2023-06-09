package UI_System.TermLibWin;

import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class UI_TermLibraryListPanel extends JPanel {
    public static final int tableRow = 12;

    public UI_TermLibraryPanel termLibraryPanel;

    public JLabel label;

    public int currentPage = 0;
    public String[] libraryNames;
    public JTable table;

    public JLabel pageNum;
    public JButton formerPage;
    public JButton nextPage;
    public JButton openLibrary;

    public UI_TermLibraryListPanel() {
        setLayout(null);
        setBackground(Color.yellow);

        label = new JLabel("当前项目术语库列表");
        label.setBounds(25, 50, 140, 50);
        add(label);

        // 创建一个 JList 实例
        table = new JTable(tableRow, 1);

        //设置坐标
        table.setBounds(25, 100, 150, 192);

        // 添加到内容面板容器
        add(table);

        //添加换页按钮
        formerPage = new JButton("上一页");
        nextPage = new JButton("下一页");
        openLibrary = new JButton("打开");

        //给换页按钮设置坐标
        formerPage.setBounds(25, 350, 50, 25);
        nextPage.setBounds(125, 350, 50, 25);

        //添加按钮
        formerPage.setMargin(new Insets(0, 0, 0, 0));
        nextPage.setMargin(new Insets(0, 0, 0, 0));

        pageNum = new JLabel("0/0");
        pageNum.setHorizontalTextPosition(JLabel.CENTER);
        pageNum.setBounds(90, 350, 50, 25);

        openLibrary.setBounds(125, 25, 50, 25);
        openLibrary.setMargin(new Insets(0, 0, 0, 0));
        openLibrary.addActionListener(e -> OnOpenLibraryButtonDown());

        add(formerPage);
        add(nextPage);
        add(pageNum);
        add(openLibrary);

        UpdateLibraryNames();
        UpdateNameList();
    }

    private void UpdateLibraryNames() {
        libraryNames = ProjectManager.instance.currentProject.GetAllTermLibraryNames();
    }

    private String[] GetCurrentPageNames() {
        int index = currentPage * tableRow;
        int end = Integer.min((currentPage + 1) * tableRow, libraryNames.length);
        return Arrays.copyOfRange(libraryNames, index, end);
    }

    private void UpdateNameList() {
        for (int i = 0; i < tableRow; i++)
            table.setValueAt("", i, 0);
        String[] currentPageNames = GetCurrentPageNames();
        for (int i = 0; i < currentPageNames.length; i++)
            table.setValueAt(currentPageNames[i], i, 0);
        UpdatePageNum();
    }

    private void UpdatePageNum() {
        pageNum.setText((currentPage + 1) + "/" + ((libraryNames.length - 1) / tableRow + 1));
    }

    private void OnOpenLibraryButtonDown() {
        int index = currentPage * tableRow + table.getSelectedRow();
        termLibraryPanel.OpenLibrary(libraryNames[index]);
    }
}
