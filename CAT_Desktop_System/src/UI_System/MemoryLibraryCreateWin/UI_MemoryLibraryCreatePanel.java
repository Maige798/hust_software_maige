package UI_System.MemoryLibraryCreateWin;

import javax.swing.*;
import java.awt.*;

public class UI_MemoryLibraryCreatePanel extends JPanel {
    JLabel memoryLibraryNameLabel=new JLabel();
    TextField text1=new TextField();

    JButton createButton=new JButton();

    JLabel savePath=new JLabel();
    TextField text2=new TextField();

    JButton browseButton=new JButton();

    public UI_MemoryLibraryCreatePanel()
    {
        this.setLayout(null);

        memoryLibraryNameLabel.setText("记忆库名称");
        this.add(memoryLibraryNameLabel);
        memoryLibraryNameLabel.setBounds(50,30,100,50);

        this.add(text1);
        text1.setBounds(50,80,350,40);

        createButton.setText("创建");
        this.add(createButton);
        createButton.setMargin(new Insets(0,0,0,0));
        createButton.setBounds(50+350+10,80,100,40);

        savePath.setText("保存路径");
        this.add(savePath);
        savePath.setBounds(50,30+100,100,50);

        this.add(text2);
        text2.setBounds(50,180,350,40);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0,0,0,0));
        browseButton.setBounds(50+350+10,180,100,40);
    }
}
