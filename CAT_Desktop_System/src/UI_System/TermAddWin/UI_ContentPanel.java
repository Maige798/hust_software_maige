package UI_System.TermAddWin;

import ProjectSystem.ProjectManager;
import SystemUtil.Language;
import SystemUtil.Sentence;
import SystemUtil.TermItem;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class UI_ContentPanel extends JPanel {
    public TextField titleField;
    public TextField termField;
    public JLabel languageLabel;
    public JComboBox<String> languageComboBox;
    public JButton confirmButton;

    public UI_ContentPanel() {
        this.setLayout(null);

        titleField = new TextField();
        termField = new TextField();
        languageLabel = new JLabel("语言");

        languageComboBox = new JComboBox<>(Language.GetAllLanguageNames());
        confirmButton = new JButton("确认");
        confirmButton.setMargin(new Insets(0, 0, 0, 0));
        confirmButton.addActionListener(e -> OnConfirmButtonDown());

        this.add(titleField);
        this.add(termField);
        this.add(languageLabel);
        this.add(languageComboBox);
        this.add(confirmButton);

        titleField.setBounds(25, 50, 150, 25);
        termField.setBounds(25, 100, 150, 25);
        languageLabel.setBounds(195, 100, 25, 25);
        languageComboBox.setBounds(225, 100, 100, 25);
        confirmButton.setBounds(225, 50, 100, 25);
    }

    private void OnConfirmButtonDown() {
        if (AbleToAdd()) {
            if (ProjectManager.instance.currentProject != null) {
                String title = titleField.getText();
                String text = termField.getText();
                Language language = Language.GetLanguage((String) languageComboBox.getSelectedItem());
                TermItem newTerm = new TermItem(title);
                newTerm.AddTerm(new Sentence(language, text));
                ProjectManager.instance.currentProject.AddTermToAllTermLibraries(newTerm);
            }
        }
    }

    private boolean AbleToAdd() {
        if (titleField.getText().equals(""))
            return false;
        else if (termField.getText().equals(""))
            return false;
        else return !Objects.equals(languageComboBox.getSelectedItem(), Language.Default.name);
    }
}
