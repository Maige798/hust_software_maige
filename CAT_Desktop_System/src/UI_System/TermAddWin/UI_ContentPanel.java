package UI_System.TermAddWin;

import javax.swing.*;
import java.awt.*;

public class UI_ContentPanel extends JPanel {
    public TextField text1;
    public TextField text2;
    public JLabel languageLable;
    public JComboBox comboBox;
    public JButton confirm;

    public UI_ContentPanel()
    {
        this.setLayout(null);

        text1=new TextField();
        text2=new TextField();
        languageLable=new JLabel("语言");
        // String[] languages=new String[]{"Default","Chinese","English"};
        comboBox=new JComboBox<>();
        confirm=new JButton("确认");
        confirm.setMargin(new Insets(0,0,0,0));


        this.add(text1);
        this.add(text2);
        this.add(languageLable);
        this.add(comboBox);
        this.add(confirm);


        text1.setBounds(25,50,150,25);
        text2.setBounds(25,100,150,25);
        languageLable.setBounds(195,100,25,25);
        comboBox.setBounds(225,100,100,25);
        confirm.setBounds(225,50,100,25);
    }




}
