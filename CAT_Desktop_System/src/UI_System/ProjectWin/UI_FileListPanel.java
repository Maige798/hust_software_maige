package UI_System.ProjectWin;

import FileSystem.TranslationFile;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UI_FileListPanel extends JPanel {
    public Color Green = new Color(61, 232, 213);
    public Color Blue = new Color(52, 89, 183);
    public static final int tableRow = 12;
    public static final int tableRaw = 12;

    public JLabel label;
    public JLabel bookPrint;

    public JTable table;

    public List<String> names=new ArrayList<>();
    public List<String> saves=new ArrayList<>();
    public JButton formerPage;
    public JButton nextPage;

    public int currentPageNum = 0;

    public UI_FileListPanel() {
        setLayout(null);
        setBackground(Green);

        label = new JLabel("项目列表");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);
        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        table = new JTable(tableRaw, 2);
        table.setRowHeight(25);
        table.setGridColor(new Color(192, 192, 192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        formerPage = new JButton("上一页");
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage = new JButton("下一页");
        nextPage.addActionListener(e -> OnNextPageButtonDown());

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

        if(ProjectManager.instance.projectList!=null) {
            for (CAT_Project project : ProjectManager.instance.projectList) {
                names.add(project.name);
                saves.add(project.save);
            }
            UpdateFileTable();
        }
    }

    private List<String> GetCurrentPageNameItems() {
        return names.subList(currentPageNum * tableRow, Integer.min((currentPageNum + 1) * tableRow,names.size()));
    }
    private List<String> GetCurrentPageSaveItems() {
        return saves.subList(currentPageNum * tableRow, Integer.min((currentPageNum + 1) * tableRow,names.size()));
    }
    private void UpdateFileTable(){
        UpdateFileItemTableByCurrentPage(GetCurrentPageNameItems(),GetCurrentPageSaveItems());
        UpDateBookPrint();
    }

    public void UpdateFileItemTableByCurrentPage(List<String> names,List<String> saves){
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

    private void UpDateBookPrint(){
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
}
