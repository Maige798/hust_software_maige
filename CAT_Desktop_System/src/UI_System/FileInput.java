package UI_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class FileInput extends JFrame {
    TextField createTextField = new TextField();

    JButton browseButton = new JButton();
    List<String> filePaths = new ArrayList<>();
    JButton inputButton;

    public FileInput() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("记忆库导入");

        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.add(createTextField);
        createTextField.setBounds(50, 130, 350, 30);

        browseButton.setText("浏览");
        panel.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(425, 130, 50, 30);
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    UpdateSavePathButton();
                }
            }
        });


        inputButton=new JButton("导入");
        panel.add(inputButton);
        inputButton.setMargin(new Insets(0,0,0,0));
        inputButton.setBounds(225,250,100,30);


        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void UpdateSavePathButton() {
        createTextField.setText(filePaths.get(filePaths.size() - 1));
    }

    public static void main(String[] args) {
        FileInput me=new FileInput();

    }
}
