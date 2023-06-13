/**
 * 类名：UI_TermCreatePanel
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，创建术语库
 * 2.开发人员：刘闯
 * 实现功能：创建术语库创建界面的内容面板
 */

package UI_System.TermLibCreate;

import ProjectSystem.ProjectManager;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;
import UI_System.TermLibraryCreateInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_TermCreatePanel extends JPanel {
    public TermLibraryCreateInterface createInterface;

    public JLabel termLibNameLabel;
    public JLabel savePathLabel;
    public TextField nameField;
    public TextField saveField;
    public JButton browseButton;

    public JButton createButton;

    public UI_TermCreatePanel(TermLibraryCreateInterface createInterface) {
        this.createInterface = createInterface;
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
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(new UI_TermCreatePanel(createInterface));
                if (option == JFileChooser.APPROVE_OPTION) {
                    saveField.setText(fileChooser.getSelectedFile().getAbsolutePath() + "\\");
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

    private void OnCreateButtonDown() {
        if (AbleToCreate()) {
            String name = nameField.getText();
            String save = saveField.getText();
            TermLibrary library = TermLibraryManager.CreateTermLibrary(name, save);
            ProjectManager.instance.currentProject.AddTermLibrary(library);
            ProjectManager.SaveProject(ProjectManager.instance.currentProject);
            createInterface.inputInterface.panel.createTextField.setText(save + name + ".tlib");
            createInterface.dispose();
        }
    }

    private boolean AbleToCreate() {
        if (nameField.getText().equals(""))
            return false;
        else
            return !saveField.getText().equals("");
    }
}
