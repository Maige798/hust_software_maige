package UI_System.FileWin;

import UI_System.CreateProject.UI_FileListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_File extends JPanel {
    public JButton inputButton;

    public JButton browseButton;
    public List<String> filePaths = new ArrayList<>();

    public TextField text1;

    public TextField text2;

    public UI_File()
    {
        this.setLayout(null);
        inputButton=new JButton("导入");
        browseButton=new JButton("浏览");
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
        text1=new TextField();
        text1.setEditable(false);
        text2=new TextField();

        this.add(inputButton);
        this.add(browseButton);
        this.add(text1);
        this.add(text2);

        inputButton.setBounds(400,100,70,40);
        browseButton.setBounds(400,200,70,40);
        text1.setBounds(40,100,300,40);
        text2.setBounds(40,200,300,40);

    }

    private void UpdateSavePathButton() {
        text2.setText(filePaths.get(filePaths.size() - 1));
    }

}
