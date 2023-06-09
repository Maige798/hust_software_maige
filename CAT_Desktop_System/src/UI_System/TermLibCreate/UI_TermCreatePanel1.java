package UI_System.TermLibCreate;

import ProjectSystem.ProjectManager;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_TermCreatePanel1 extends JPanel {
    public JLabel termLibNameLabel;
    public JLabel savePathLabel;
    public TextField nameField;
    public TextField saveField;
    public JButton browseButton;
    public List<String> filePaths = new ArrayList<>();

    public JButton createButton;

    public UI_TermCreatePanel1() {
        this.setLayout(null);

        //创建三对标签文本框并设置位置
        termLibNameLabel = new JLabel("术语库创建");
        savePathLabel = new JLabel("存储路径");
        browseButton = new JButton("浏览");
        nameField = new TextField();
        saveField = new TextField();
        createButton = new JButton("完成创建");

        //创建监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_TermCreatePanel1());
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(filePaths.get(0));
                    UpdateSavePathButton();
                }
            }
        });

        this.add(termLibNameLabel);
        this.add(savePathLabel);

        this.add(nameField);
        this.add(saveField);

        this.add(browseButton);
        this.add(createButton);

        termLibNameLabel.setBounds(50, 50, 75, 25);
        nameField.setBounds(50, 75, 300, 25);

        savePathLabel.setBounds(50, 125, 75, 25);
        saveField.setBounds(50, 150, 300, 25);

        browseButton.setBounds(360, 150, 75, 25);
        createButton.setBounds(200, 220, 100, 25);
        createButton.addActionListener(e -> OnCreateButtonDown());
    }

    private void UpdateSavePathButton() {
        saveField.setText(filePaths.get(filePaths.size() - 1));
    }

    private void OnCreateButtonDown() {
        if (AbleToCreate()) {
            String name = nameField.getText();
            String save = saveField.getText();
            TermLibrary library = TermLibraryManager.CreateTermLibrary(name, save);
            ProjectManager.instance.currentProject.AddTermLibrary(library);
            ProjectManager.SaveProject(ProjectManager.instance.currentProject);
        }
    }

    private boolean AbleToCreate() {
        if (nameField.getText().equals(""))
            return false;
        else
            return !saveField.getText().equals("");
    }
}
