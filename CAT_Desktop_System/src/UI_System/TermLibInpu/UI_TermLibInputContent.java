package UI_System.TermLibInpu;

import TermLibrarySystem.TermLibraryManager;

import javax.swing.*;
import java.awt.*;

public class UI_TermLibInputContent extends JPanel {
    JLabel memoryLibraryImportLabel = new JLabel();

    TextField createTextField = new TextField();

    JButton browseButton = new JButton();

    JButton createButton = new JButton();

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


        createButton.setText("新建");
        this.add(createButton);
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.setBounds(130, 250, 100, 30);

        importButton.setText("导入");
        this.add(importButton);
        importButton.setMargin(new Insets(0, 0, 0, 0));
        importButton.setBounds(300, 250, 100, 30);
    }

    private void OnImportButtonDown(){
        if(!createTextField.getText().equals("")) {
            TermLibraryManager.LoadLibrary(createTextField.getText());
        }
    }
}
