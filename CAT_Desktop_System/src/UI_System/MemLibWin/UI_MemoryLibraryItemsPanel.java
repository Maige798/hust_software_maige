/**
 * 类名：UI_MemoryLibraryItemsPanel
 * 1.开发人员：阮泽同
 * 实现功能：实现与内核的交互，展示记忆条目，翻页，记忆条目编辑、删除、筛选功能
 * 2.开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的记忆库条目面板，并添加定位相关组件
 */

package UI_System.MemLibWin;

import MemoryLibrarySystem.MemoryLibraryManager;
import ProjectSystem.ProjectManager;
import SystemUtil.TranslationItem;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class UI_MemoryLibraryItemsPanel extends JPanel {
    public UI_MemoryLibraryDetailsPanel memoryLibraryDetailsPanel;

    public Color Green = new Color(204, 255, 128);
    public Color Blue = new Color(64, 0, 128);

    public static final int tableRows = 18; // 记忆库条目列表的行数

    public JLabel label;
    public JLabel bookPrint;

    public JTable table;

    public JButton deleteButton;
    public JButton cancelButton;
    public JButton saveButton;
    public int currentPageNum = 0;
    public JButton formerPage;
    public JButton nextPage;

    public TranslationItem[] currentMemoryLibraryItems;

    public UI_MemoryLibraryItemsPanel(UI_MemoryLibraryDetailsPanel memoryLibraryDetailsPanel) {
        this.memoryLibraryDetailsPanel=memoryLibraryDetailsPanel;
        setLayout(null);
        setBackground(Green);

        label = new JLabel("记忆库条目");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);

        bookPrint = new JLabel("0/0");
        bookPrint.setForeground(Color.BLACK);

        table = new JTable(tableRows, 2);
        table.setRowHeight(21);
        table.setGridColor(new Color(192, 192, 192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        deleteButton = new JButton("标记删除");
        deleteButton.addActionListener(e -> OnDeleteButtonDown());
        cancelButton = new JButton("取消更改");
        cancelButton.addActionListener(e -> OnCancelButtonDown());
        saveButton = new JButton("保存更改");
        saveButton.addActionListener(e -> OnSaveButtonDown());

        formerPage = new JButton("上一页");
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage = new JButton("下一页");
        nextPage.addActionListener(e -> OnNextPageButtonDown());

        add(label);
        add(bookPrint);
        add(table);
        add(deleteButton);
        add(cancelButton);
        add(saveButton);
        add(formerPage);
        add(nextPage);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(660, 450, 40, 20);
        table.setBounds(30, 50, 740, 378);
        formerPage.setBounds(570, 450, 80, 20);
        nextPage.setBounds(690, 450, 80, 20);
        deleteButton.setBounds(200, 450, 90, 20);
        cancelButton.setBounds(310, 450, 90, 20);
        saveButton.setBounds(420, 450, 90, 20);

        if (ProjectManager.instance.currentProject != null) {
            if (ProjectManager.instance.currentProject.memoryLibrary != null) {
                currentMemoryLibraryItems = ProjectManager.instance.currentProject.memoryLibrary.GetAllItems();
                UpdateItemTable();
            }
        }
    }

    private TranslationItem[] GetCurrentPageItems() {
        return Arrays.copyOfRange(currentMemoryLibraryItems,
                currentPageNum * tableRows, Integer.min((currentPageNum + 1) * tableRows, currentMemoryLibraryItems.length));
    }

    public void UpdateItemTable() {
        UpdateItemTableByCurrentPage(GetCurrentPageItems());
        UpdateBookPrint();
        UpdateMemoryLibraryDetailsPanel();
    }

    private void UpdateItemTableByCurrentPage(TranslationItem[] items) {
        if (items.length > tableRows)
            System.err.println("Expected length: <=18, actual length: " + items.length);
        for (int i = 0; i < tableRows; i++) {
            table.setValueAt("", i, 0);
            table.setValueAt("", i, 1);
        }
        for (int i = 0; i < items.length; i++) {
            table.setValueAt(items[i].origin.text, i, 0);
            table.setValueAt(items[i].translation.text, i, 1);
        }
    }

    private void UpdateBookPrint() {
        bookPrint.setText((currentPageNum + 1) + "/" + (currentMemoryLibraryItems.length / tableRows + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPageNum > 0) {
            currentPageNum--;
            UpdateItemTable();
        }
    }

    private void OnNextPageButtonDown() {
        if (currentPageNum < currentMemoryLibraryItems.length / tableRows) {
            currentPageNum++;
            UpdateItemTable();
        }
    }

    private void OnCancelButtonDown() {
        UpdateItemTable();
    }

    private void OnDeleteButtonDown() {
        int index = table.getSelectedRow() + currentPageNum * tableRows;
        if (index < currentMemoryLibraryItems.length) {
            ProjectManager.instance.currentProject.memoryLibrary.RemoveItem(currentMemoryLibraryItems[index]);
            MemoryLibraryManager.SaveLibrary(ProjectManager.instance.currentProject.memoryLibrary);
            currentMemoryLibraryItems = ProjectManager.instance.currentProject.memoryLibrary.GetAllItems();
            UpdateItemTable();
        }
    }

    private void OnSaveButtonDown() {
        int beginIndex = currentPageNum * tableRows;
        for (int i = 0; i < tableRows && (beginIndex + i) < currentMemoryLibraryItems.length; i++) {
            String origin = (String) table.getValueAt(i, 0);
            String translation = (String) table.getValueAt(i, 1);
            ProjectManager.instance.currentProject.memoryLibrary.
                    EditItem(currentMemoryLibraryItems[beginIndex + i], origin, translation);
        }
        currentMemoryLibraryItems = ProjectManager.instance.currentProject.memoryLibrary.GetAllItems();
        UpdateItemTable();
    }

    private void UpdateMemoryLibraryDetailsPanel() {
        memoryLibraryDetailsPanel.SetText(ProjectManager.instance.currentProject.memoryLibrary.GetAttributeMessage());
    }
}
