/**
 * 类名：UI_FileDerivePanel
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，实现导出功能
 * 2.开发人员：刘闯
 * 实现功能：实现文件界面内容面板的界面
 */

package UI_System.FileDeriveWin;

import FileSystem.TranslationFileManager;
import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UI_FileDerivePanel extends JPanel {
    public JFrame frame;

    public JLabel label;

    public JButton deriveButton;

    public JButton browseButton;

    public TextField nameField;

    public TextField saveField;

    public UI_FileDerivePanel(JFrame frame) {
        this.frame=frame;

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
                    saveField.setText(fileChooser.getSelectedFile().getAbsolutePath()+"\\");
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

    private void OnDeriveButtonDown() {
        if (AbleToDerive()) {
            String name = nameField.getText();
            String save = saveField.getText();
            TranslationFileManager.DeriveFile(ProjectManager.instance.currentTranslationFile, save, name);
            frame.dispose();
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
