package UI_System.FileDeriveWin;

import FileSystem.TranslationFileManager;
import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_FileDerivePanel extends JPanel {
    public JLabel label;

    public JButton deriveButton;

    public JButton browseButton;
    public List<String> filePaths = new ArrayList<>();

    public TextField nameField;

    public TextField saveField;

    public UI_FileDerivePanel() {
        this.setLayout(null);
        deriveButton = new JButton("导出");
        deriveButton.addActionListener(e -> OnDeriveButtonDown());

        browseButton = new JButton("浏览");
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(filePaths.get(0));
                    UpdateSavePathButton();
                }
            }
        });
        nameField = new TextField();
        saveField = new TextField();

        label = new JLabel("导出翻译文件：" + ProjectManager.instance.currentTranslationFile.name);
        label.setBounds(40, 50, 300, 40);

        this.add(deriveButton);
        this.add(browseButton);
        this.add(nameField);
        this.add(saveField);
        this.add(label);

        deriveButton.setBounds(400, 100, 70, 40);
        browseButton.setBounds(400, 200, 70, 40);
        nameField.setBounds(40, 100, 300, 40);
        saveField.setBounds(40, 200, 300, 40);
    }

    private void UpdateSavePathButton() {
        saveField.setText(filePaths.get(filePaths.size() - 1) + "\\");
    }

    private void OnDeriveButtonDown() {
        if (AbleToDerive()) {
            String name = nameField.getText();
            String save = saveField.getText();
            TranslationFileManager.DeriveFile(ProjectManager.instance.currentTranslationFile, save, name);
        }
    }

    private boolean AbleToDerive() {
        if (nameField.getText().equals(""))
            return false;
        else if (saveField.getText().equals(""))
            return false;
        else return ProjectManager.instance.currentTranslationFile != null;
    }
}
