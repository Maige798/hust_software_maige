package javaswing.CreateProject;


import javax.swing.*;

public class UI_ContentPanel extends JPanel {
    // public UI_NameAndPathPanel panel1=new UI_NameAndPathPanel();
    public UI_FileListPanel panel2=new UI_FileListPanel();

    public UI_ContentPanel()
    {
        this.setLayout(null);

        this.add(panel2);


        panel2.setBounds(0,0,750,500);
        //  panel2.setBounds(0,210,250,190);
    }
}