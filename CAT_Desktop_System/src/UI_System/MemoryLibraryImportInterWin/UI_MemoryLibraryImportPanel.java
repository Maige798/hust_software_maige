package UI_System.MemoryLibraryImportInterWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_MemoryLibraryImportPanel extends JPanel {
    JLabel memoryLibraryImportLabel =new JLabel();

    TextField createTextField=new TextField();

    JButton browseButton=new JButton();
    List<String> memoryLibPaths=new ArrayList<>();
    JButton newCreateButton=new JButton();
    JButton importButton=new JButton();




    public UI_MemoryLibraryImportPanel()
    {
        this.setLayout(null);

        memoryLibraryImportLabel.setText("记忆库导入");
        this.add(memoryLibraryImportLabel);
        memoryLibraryImportLabel.setBounds(25,20,175,50);

        this.add(createTextField);
        createTextField.setBounds(50,130,350,30);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0,0,0,0));
        browseButton.setBounds(425,130,50,30);
        //设置浏览监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                int option=fileChooser.showOpenDialog(new UI_MemoryLibraryImportPanel());
                if(option==JFileChooser.APPROVE_OPTION){
                    memoryLibPaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    UpdateSavePathButton(memoryLibPaths);
                }
            }
        });
//        JFileChooser fileChooser=new JFileChooser();
//        int option =fileChooser.showOpenDialog(new UI_FileListPanel());
//        if(option==JFileChooser.APPROVE_OPTION){
//            fileNames.add(fileChooser.getSelectedFile().getAbsolutePath());
//            System.out.println(fileNames.get(fileNames.size()-1));
//            UpdateTable(fileNames);
newCreateButton.setText("新建");
        this.add(newCreateButton);
        newCreateButton.setMargin(new Insets(0,0,0,0));
        newCreateButton.setBounds(130,250,100,30);

        importButton.setText("导入");
        this.add(importButton);
        importButton.setMargin(new Insets(0,0,0,0));
        importButton.setBounds(300,250,100,30);



    }
    private void UpdateSavePathButton(List<String> fileNames)
    {
        createTextField.setText(fileNames.get(fileNames.size()-1));
    }

}
