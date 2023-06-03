package UI_System.MemoryLibraryCreateWin;

import SystemUtil.Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_MemoryLibraryCreatePanel extends JPanel {
    JLabel memoryLibraryNameLabel=new JLabel();
    TextField text1=new TextField();

    JButton createButton=new JButton();

    JLabel savePath=new JLabel();
    TextField text2=new TextField();

    JButton browseButton=new JButton();
    List<String> memoryLibPaths=new ArrayList<>();

    public JLabel beginLabel;
    public JComboBox<String> originLanguageComboBox;
    public JLabel goalLabel;
    public JComboBox<String> targetLanguageComboBox;

    public UI_MemoryLibraryCreatePanel()
    {
        this.setLayout(null);

        memoryLibraryNameLabel.setText("记忆库名称");
        this.add(memoryLibraryNameLabel);
        memoryLibraryNameLabel.setBounds(20,30,100,50);

        this.add(text1);
        text1.setBounds(20,80,260,40);

        createButton.setText("创建");
        this.add(createButton);
        createButton.setMargin(new Insets(0,0,0,0));
        createButton.setBounds(310,80,100,40);

        savePath.setText("保存路径");
        this.add(savePath);
        savePath.setBounds(20,30+100,100,50);

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

        this.add(text2);
        text2.setBounds(20,180,260,40);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0,0,0,0));
        browseButton.setBounds(310,180,100,40);
        //创建监听器
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser=new JFileChooser();
                int option=fileChooser.showOpenDialog(new UI_MemoryLibraryCreatePanel());
                if(option==JFileChooser.APPROVE_OPTION)
                {
                    memoryLibPaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    UpdateSavePathButton(memoryLibPaths);
                }

            }
        });
    }
//    JFileChooser fileChooser=new JFileChooser();
//    int option =fileChooser.showOpenDialog(new UI_MemoryLibraryCreatePanel());
//                if(option==JFileChooser.APPROVE_OPTION){
//        memoryLibPaths.add(fileChooser.getSelectedFile().getAbsolutePath());
//        System.out.println(memoryLibPaths.get(memoryLibPaths.size()-1));
//        UpdateSa(memoryLibPaths);

    private void UpdateSavePathButton(List<String> fileNames)
    {
        text2.setText(memoryLibPaths.get(memoryLibPaths.size()-1));
    }

}
