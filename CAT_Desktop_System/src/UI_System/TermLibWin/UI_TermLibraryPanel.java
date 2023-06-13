/**
 * 类名：UI_TermLibraryPanel
 * 1.开发人员：阮泽同
 * 实现功能：展示术语条目，术语筛选、删除功能、翻页功能
 * 2.开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的术语库基本条目面板，并添加定位相关组件
 */

package UI_System.TermLibWin;

import ProjectSystem.ProjectManager;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class UI_TermLibraryPanel extends JPanel {
    public static final int tableRow = 18;

    public Color Green = new Color(204, 255, 128);
    public Color Blue = new Color(64, 0, 128);

    public JLabel label;

    public String[] titles;
    public String[] contents;
    public List<TermLibrary> libraries;
    public TermLibrary currentLibrary;
    public JTable table;

    public JButton deleteButton;


    public int currentPage;
    public JLabel bookPrint;
    public JButton formerPage;
    public JButton nextPage;

    public UI_TermLibraryPanel() {
        setLayout(null);
        setBackground(Green);

        label = new JLabel("术语库条目");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);
        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        table = new JTable(tableRow, 2);
        table.setRowHeight(21);
        table.setGridColor(new Color(192, 192, 192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        deleteButton = new JButton("删除");

        formerPage = new JButton("上一页");
        nextPage = new JButton("下一页");

        add(label);
        add(bookPrint);
        add(table);
        add(deleteButton);
        add(formerPage);
        add(nextPage);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(660, 450, 40, 20);
        table.setBounds(30, 50, 740, 378);

        formerPage.setBounds(570, 450, 80, 20);
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage.setBounds(690, 450, 80, 20);
        nextPage.addActionListener(e -> OnNextPageButtonDown());

        deleteButton.setBounds(400, 450, 90, 20);
        deleteButton.addActionListener(e -> OnDeleteButtonDown());
        UpDateLibraries();
    }

    public void UpDateLibraries() {
        if (!ProjectManager.instance.currentProject.termLibraryList.isEmpty())
            libraries = ProjectManager.instance.currentProject.termLibraryList;
        OpenLibrary(0); // 默认打开首个术语库
    }

    public void OpenLibrary(int num) {
        if (num < libraries.size())
            currentLibrary = libraries.get(num);
        currentPage = 0; // 每次打开新术语库时回到首页
        UpdateMessagesByCurrentLibrary();
        UpdateTableItems();
    }

    public void OpenLibrary(String name) {
        for (TermLibrary library : libraries) {
            if (library.name.equals(name)) {
                currentLibrary = library;
                break;
            }
        }
        currentPage = 0; // 每次打开新术语库时回到首页
        UpdateMessagesByCurrentLibrary();
        UpdateTableItems();
    }

    public void UpdateTableItems() {
        if (currentLibrary != null) {
            for (int i = 0; i < tableRow; i++) {
                table.setValueAt("", i, 0);
                table.setValueAt("", i, 1);
            }
            String[] currentPageTitles = GetCurrentPageTitles();
            String[] currentPageContents = GetCurrentPageContents();
            for (int i = 0; i < currentPageTitles.length; i++) {
                table.setValueAt(currentPageTitles[i], i, 0);
                table.setValueAt(currentPageContents[i], i, 1);
            }
            UpdateBookPrint();
        }
    }

    private void UpdateMessagesByCurrentLibrary() {
        if (currentLibrary != null) {
            titles = currentLibrary.GetAllTitles();
            contents = currentLibrary.GetAllTerms();
        }
    }

    public void UpdateMessagesByCurrentLibrary(String text) {
        if (currentLibrary != null) {
            titles = currentLibrary.GetAllTitles(text);
            contents = currentLibrary.GetAllTerms(text);
        }
    }

    private String[] GetCurrentPageTitles() {
        int index = currentPage * tableRow;
        int end = Integer.min((currentPage + 1) * tableRow, titles.length);
        return Arrays.copyOfRange(titles, index, end);
    }

    private String[] GetCurrentPageContents() {
        int index = currentPage * tableRow;
        int end = Integer.min((currentPage + 1) * tableRow, contents.length);
        return Arrays.copyOfRange(contents, index, end);
    }

    private void UpdateBookPrint() {
        bookPrint.setText((currentPage + 1) + "/" + ((titles.length - 1) / tableRow + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPage > 0)
            currentPage--;
        UpdateTableItems();
    }

    private void OnNextPageButtonDown() {
        if (currentPage < (titles.length - 1) / tableRow)
            currentPage++;
        UpdateTableItems();
    }

    private void OnDeleteButtonDown() {
        int index = currentPage * tableRow + table.getSelectedRow();
        currentLibrary.RemoveItem(titles[index]);
        TermLibraryManager.SaveLibrary(currentLibrary);
        UpdateMessagesByCurrentLibrary();
        UpdateTableItems();
    }
}
