package javaswing.WelcomeWin;

import javax.swing.*;
import java.awt.*;

public class UI_ContentPanel extends JPanel {
    JLabel welcomeLabel;
    JButton createButton;
    JButton openButton;
    JTable table;
    public UI_ContentPanel()
    {
        this.setLayout(null);

        welcomeLabel=new JLabel("欢迎使用");
        createButton=new JButton("新建项目");
        createButton.setMargin(new Insets(0,0,0,0));
        openButton=new JButton("打开");
        openButton.setMargin(new Insets(0,0,0,0));
        table=new JTable(5,1);
        table.setRowHeight(50);

        this.add(welcomeLabel);
        this.add(createButton);
        this.add(openButton);
        this.add(table);

        welcomeLabel.setBounds(40,30,100,30);
        createButton.setBounds(160,30,60,30);
        openButton.setBounds(230,30,60,30);
        table.setBounds(40,90,260,300);

    }
}
