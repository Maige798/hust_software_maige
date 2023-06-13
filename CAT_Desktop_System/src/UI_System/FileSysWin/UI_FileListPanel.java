/**
 * 类名：UI_FileListPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计文件框架中的文件列表面板，并添加定位相关组件
 */

package UI_System.FileSysWin;

import FileSystem.TranslationFile;
import ProjectSystem.ProjectManager;
import UI_System.EditorWindow;
import UI_System.FileImportWindow;
import UI_System.FileSystemWindow;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UI_FileListPanel extends JPanel {
    public FileSystemWindow frame;

    public UI_FileDetailsPanel fileDetailsPanel;

    public Color Green = new Color(61, 232, 213);
    public Color Blue = new Color(52, 89, 183);

    public static final int tableRow = 12;

    public JLabel label;
    public JLabel bookPrint;

    public List<String> names = new ArrayList<>();
    public List<String> saves = new ArrayList<>();

    public JTable table;
    public JButton formerPage;
    public JButton nextPage;

    public JButton openButton;
    public JButton importButton;

    public int currentPageNum = 0;

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
        table.getSelectionModel().addListSelectionListener(e -> UpdateFileDetailsPanel());

        formerPage = new JButton("上一页");
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage = new JButton("下一页");
        nextPage.addActionListener(e -> OnNextPageButtonDown());

        openButton = new JButton("打开");
        openButton.addActionListener(e -> OnOpenFileButtonDown());
        importButton = new JButton("导入");
        importButton.addActionListener(e -> OnImportButtonDown());

        add(label);
        add(bookPrint);
        add(table);
        add(formerPage);
        add(nextPage);
        add(openButton);
        add(importButton);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(615, 370, 40, 20);
        table.setBounds(30, 50, 740, 300);
        formerPage.setBounds(500, 370, 90, 20);
        nextPage.setBounds(655, 370, 90, 20);

        openButton.setBounds(350, 370, 80, 20);
        importButton.setBounds(200, 370, 80, 20);

        UpdateNamesAndSaves();
    }

    public void UpdateNamesAndSaves() {
        if (ProjectManager.instance.currentProject != null) {
            names.clear();
            saves.clear();
            for (TranslationFile file : ProjectManager.instance.currentProject.translationFileList) {
                names.add(file.name);
                saves.add(file.save);
            }
            UpdateFileTable();
        }
    }

    private List<String> GetCurrentPageNameItems() {
        return names.subList(currentPageNum * tableRow, Integer.min((currentPageNum + 1) * tableRow, names.size()));
    }

    private List<String> GetCurrentPageSaveItems() {
        return saves.subList(currentPageNum * tableRow, Integer.min((currentPageNum + 1) * tableRow, names.size()));
    }

    private void UpdateFileTable() {
        UpdateFileItemTableByCurrentPage();
        UpDateBookPrint();
    }

    public void UpdateFileItemTableByCurrentPage() {
        List<String> names = GetCurrentPageNameItems();
        List<String> saves = GetCurrentPageSaveItems();
        if (names.size() > tableRow)
            System.err.println("Expected length: <=12, actual length: " + names.size());
        for (int i = 0; i < tableRow; i++) {
            table.setValueAt("", i, 0);
            table.setValueAt("", i, 1);
        }
        for (int i = 0; i < names.size(); i++) {
            table.setValueAt(names.get(i), i, 0);
            table.setValueAt(saves.get(i), i, 1);
        }
    }

    private void UpDateBookPrint() {
        bookPrint.setText((currentPageNum + 1) + "/" + (names.size() / tableRow + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPageNum > 0) {
            currentPageNum--;
            UpdateFileTable();
        }
    }

    private void OnNextPageButtonDown() {
        if (currentPageNum < names.size() / tableRow) {
            currentPageNum++;
            UpdateFileTable();
        }
    }

    private void UpdateFileDetailsPanel() {
        int index = currentPageNum * tableRow + table.getSelectedRow();
        if (index < names.size())
            fileDetailsPanel.SetText(ProjectManager.instance.currentProject.GetTranslationFile(index).GetAttributeMessage());
        else
            fileDetailsPanel.SetText("");
    }

    private void OnOpenFileButtonDown() {
        int index = currentPageNum * tableRow + table.getSelectedRow();
        if (index < names.size()) {
            ProjectManager.TranslateFile(ProjectManager.instance.currentProject.GetTranslationFile(index));
            EditorWindow window = new EditorWindow();
            frame.dispose();
        }
    }

    private void OnImportButtonDown() {
        new FileImportWindow(frame);
    }
}
