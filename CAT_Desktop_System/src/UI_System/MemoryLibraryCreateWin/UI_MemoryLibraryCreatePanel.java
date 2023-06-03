package UI_System.MemoryLibraryCreateWin;

import MemoryLibrarySystem.MemoryLibraryManager;
import SystemUtil.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UI_MemoryLibraryCreatePanel extends JPanel {
    JLabel memoryLibraryNameLabel = new JLabel();
    TextField nameField = new TextField();

    JButton createButton = new JButton();

    JLabel savePath = new JLabel();
    TextField saveField = new TextField();

    JButton browseButton = new JButton();
    List<String> memoryLibPaths = new ArrayList<>();

    public JLabel beginLabel;
    public JComboBox<String> originLanguageComboBox;
    public JLabel goalLabel;
    public JComboBox<String> targetLanguageComboBox;

    public UI_MemoryLibraryCreatePanel() {
        this.setLayout(null);

        memoryLibraryNameLabel.setText("记忆库名称");
        this.add(memoryLibraryNameLabel);
        memoryLibraryNameLabel.setBounds(20, 30, 100, 50);

        this.add(nameField);
        nameField.setBounds(20, 80, 260, 40);

        createButton.setText("创建");
        this.add(createButton);
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.setBounds(310, 80, 100, 40);
        createButton.addActionListener(e -> OnCreateButtonDown());

        savePath.setText("保存路径");
        this.add(savePath);
        savePath.setBounds(20, 30 + 100, 100, 50);

        beginLabel = new JLabel("源语言");
        goalLabel = new JLabel("目标语言");
        String[] language = Language.GetAllLanguageNames();
        originLanguageComboBox = new JComboBox<>(language);
        targetLanguageComboBox = new JComboBox<>(language);

        this.add(beginLabel);
        this.add(goalLabel);
        this.add(originLanguageComboBox);
        this.add(targetLanguageComboBox);

        beginLabel.setBounds(430, 85, 50, 30);
        goalLabel.setBounds(420, 185, 50, 30);
        originLanguageComboBox.setBounds(470, 85, 100, 30);
        targetLanguageComboBox.setBounds(470, 185, 100, 30);

        this.add(saveField);
        saveField.setBounds(20, 180, 260, 40);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(310, 180, 100, 40);
        //创建监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_MemoryLibraryCreatePanel());
                if (option == JFileChooser.APPROVE_OPTION) {
                    memoryLibPaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    UpdateSavePathButton(memoryLibPaths);
                }
            }
        });
    }

    private void UpdateSavePathButton(List<String> fileNames) {
        saveField.setText(memoryLibPaths.get(memoryLibPaths.size() - 1));
    }

    private void OnCreateButtonDown() {
        if (AbleToCreate()) {
            String name = nameField.getText();
            String save = saveField.getText();
            Language origin = Language.GetLanguage((String) originLanguageComboBox.getSelectedItem());
            Language target = Language.GetLanguage((String) targetLanguageComboBox.getSelectedItem());
            MemoryLibraryManager.CreateMemoryLibrary(name, save, origin, target);
        }
    }

    private boolean AbleToCreate() {
        if (nameField.getText().equals(""))
            return false;
        else if (saveField.getText().equals(""))
            return false;
        else if (Objects.equals(originLanguageComboBox.getSelectedItem(), Language.Default.name))
            return false;
        else return !Objects.equals(targetLanguageComboBox.getSelectedItem(), Language.Default.name);
    }
}
