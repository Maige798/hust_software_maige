package UI_System.TermLibInpu;

import MemoryLibrarySystem.MemoryLibraryManager;
import ProjectSystem.ProjectManager;
import UI_System.MemoryLibraryImportInterWin.UI_MemoryLibraryImportPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_TermLibInputContent extends JPanel {
    JLabel memoryLibraryImportLabel = new JLabel();

    TextField createTextField = new TextField();

    JButton browseButton = new JButton();
    java.util.List<String> memoryLibPaths = new ArrayList<>();
    JButton newCreateButton = new JButton();

    JButton importButton = new JButton();


    public UI_TermLibInputContent() {
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


        newCreateButton.setText("新建");
        this.add(newCreateButton);
        newCreateButton.setMargin(new Insets(0, 0, 0, 0));
        newCreateButton.setBounds(130, 250, 100, 30);

        importButton.setText("导入");
        this.add(importButton);
        importButton.setMargin(new Insets(0, 0, 0, 0));
        importButton.setBounds(300, 250, 100, 30);
    }


}
