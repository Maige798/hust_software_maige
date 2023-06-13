/**
 * 类名：UI_MemoryLibraryImportPanel
 * 1.开发人员：阮泽同
 * 实现功能：实现与内核的交互，导入记忆库
 * 2.开发人员：
 * 实现功能：
 */

package UI_System.MemoryLibraryImportInterWin;

import MemoryLibrarySystem.MemoryLibraryManager;
import ProjectSystem.ProjectManager;
import UI_System.MemoryLibraryCreateInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_MemoryLibraryImportPanel extends JPanel {
    JLabel memoryLibraryImportLabel = new JLabel();

    TextField createTextField = new TextField();

    JButton browseButton = new JButton();
    List<String> memoryLibPaths = new ArrayList<>();
    JButton createButton = new JButton();

    JButton importButton = new JButton();


    public UI_MemoryLibraryImportPanel() {
        this.setLayout(null);

        memoryLibraryImportLabel.setText("记忆库导入");
        this.add(memoryLibraryImportLabel);
        memoryLibraryImportLabel.setBounds(25, 20, 175, 50);

        this.add(createTextField);
        createTextField.setBounds(50, 130, 350, 30);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(425, 130, 50, 30);
        //设置浏览监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(new UI_MemoryLibraryImportPanel());
                if (option == JFileChooser.APPROVE_OPTION) {
                    memoryLibPaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    UpdateSavePathButton(memoryLibPaths);
                }
            }
        });

        createButton.setText("新建");
        this.add(createButton);
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.setBounds(130, 250, 100, 30);
        createButton.addActionListener(e -> OnCreateButtonDown());

        importButton.setText("导入");
        this.add(importButton);
        importButton.setMargin(new Insets(0, 0, 0, 0));
        importButton.setBounds(300, 250, 100, 30);
        importButton.addActionListener(e -> OnImportButtonDown());
    }

    private void UpdateSavePathButton(List<String> fileNames) {
        createTextField.setText(fileNames.get(fileNames.size() - 1));
    }

    private void OnImportButtonDown() {
        if (!createTextField.getText().equals("")) {
            if (ProjectManager.instance.currentProject != null) {
                String save = createTextField.getText();
                ProjectManager.instance.currentProject.SetMemoryLibrary(MemoryLibraryManager.LoadLibrary(save));
                ProjectManager.SaveProject(ProjectManager.instance.currentProject);
                System.out.println(ProjectManager.instance.currentProject.memoryLibrary);
            }
        }
    }

    private void OnCreateButtonDown() {
        MemoryLibraryCreateInterface window = new MemoryLibraryCreateInterface();
    }
}
