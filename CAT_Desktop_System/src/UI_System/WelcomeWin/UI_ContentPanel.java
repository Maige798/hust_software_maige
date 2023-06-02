package UI_System.WelcomeWin;

import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import UI_System.CreateProjectInterface;

import javax.swing.*;
import java.awt.*;

public class UI_ContentPanel extends JPanel {
    JLabel welcomeLabel;
    JButton createButton;
    JButton openButton;
    JTable table;

    public UI_ContentPanel() {
        this.setLayout(null);

        welcomeLabel = new JLabel("欢迎使用");

        createButton = new JButton("新建项目");
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.addActionListener(e -> {
            OnCreateButtonDown();
        });

        openButton = new JButton("打开");
        openButton.setMargin(new Insets(0, 0, 0, 0));
        openButton.addActionListener(e -> {
            OnOpenButtonDown();
            System.out.println(ProjectManager.instance.currentProject);
        });

        table = new JTable(5, 1);
        table.setRowHeight(50);

        this.add(welcomeLabel);
        this.add(createButton);
        this.add(openButton);
        this.add(table);

        welcomeLabel.setBounds(40, 30, 100, 30);
        createButton.setBounds(160, 30, 60, 30);
        openButton.setBounds(230, 30, 60, 30);
        table.setBounds(40, 90, 260, 300);
        SetUpTable();
    }

    public void SetUpTable() {
        UpdateTable(ProjectManager.SendWelcomeWindowMessage());
    }

    public void UpdateTable(String[] messages) {
        for (int i = 0; i < messages.length; i++)
            table.setValueAt(messages[i], i, 0);
    }

    private void OnOpenButtonDown() {
        int number = table.getSelectedRow();
        ProjectManager.OpenProject(ProjectManager.GetProject((String) table.getValueAt(number, 0)));
    }

    private void OnCreateButtonDown() {
        CreateProjectInterface createProjectInterface=new CreateProjectInterface();
    }
}
