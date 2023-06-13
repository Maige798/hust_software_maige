/**
 * 类名：UI_FileListPanel
 * 1.开发人员：阮泽同
 * 实现功能：与项目信息面板的交互，切换至创建项目界面
 * 2.开发人员：王琢玉
 * 实现功能：相对于框架独立设计文件框架中的项目文件列表面板，并添加定位相关组件
 */

package UI_System.ProjectWin;

import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import UI_System.CreateProjectInterface;
import UI_System.FileSystemWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UI_FileListPanel extends JPanel {
    public JFrame frame;

    public UI_ProjectDetailsPanel projectDetailsPanel;

    public Color Green = new Color(61, 232, 213);
    public Color Blue = new Color(52, 89, 183);

    public static final int tableRow = 12;
    public static final int tableRaw = 12;

    public JLabel label;
    public JLabel bookPrint;

    public JTable table;

    public List<String> names = new ArrayList<>();
    public List<String> saves = new ArrayList<>();
    public JButton formerPage;
    public JButton nextPage;

    public JButton openProject;
    public JButton createProject;

    public int currentPageNum = 0;

    public UI_FileListPanel(JFrame frame) {
        this.frame=frame;
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
        table.getSelectionModel().addListSelectionListener(e -> UpdateProjectDetailsPanel());

        formerPage = new JButton("上一页");
        formerPage.addActionListener(e -> OnFormerPageButtonDown());
        nextPage = new JButton("下一页");
        nextPage.addActionListener(e -> OnNextPageButtonDown());

        openProject = new JButton("打开");
        openProject.addActionListener(e -> OnOpenProjectButtonDown());
        createProject=new JButton("新建");
        createProject.addActionListener(e -> OnCreateButtonDown());

        add(label);
        add(bookPrint);
        add(table);
        add(formerPage);
        add(nextPage);
        add(openProject);
        add(createProject);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(615, 370, 40, 20);
        table.setBounds(30, 50, 740, 300);
        formerPage.setBounds(500, 370, 90, 20);
        nextPage.setBounds(655, 370, 90, 20);

        openProject.setBounds(350, 370, 90, 20);
        createProject.setBounds(200,370, 90, 20);

        if (ProjectManager.instance.projectList != null) {
            for (CAT_Project project : ProjectManager.instance.projectList) {
                names.add(project.name);
                saves.add(project.save);
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
        UpdateFileItemTableByCurrentPage(GetCurrentPageNameItems(), GetCurrentPageSaveItems());
        UpDateBookPrint();
    }

    public void UpdateFileItemTableByCurrentPage(List<String> names, List<String> saves) {
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

    private void OnOpenProjectButtonDown(){
        int index=currentPageNum*tableRow+table.getSelectedRow();
        ProjectManager.OpenProject(names.get(index));
        FileSystemWindow window=new FileSystemWindow();
        frame.dispose();
    }

    private void UpdateProjectDetailsPanel() {
        int index = currentPageNum * tableRow + table.getSelectedRow();
        if (index < names.size())
            projectDetailsPanel.SetTextField(Objects.requireNonNull(ProjectManager.GetProject(names.get(index))).GetAttributeMessage());
        else
            projectDetailsPanel.SetTextField("");
    }

    private void OnCreateButtonDown(){
        new CreateProjectInterface();
        frame.dispose();
    }
}
