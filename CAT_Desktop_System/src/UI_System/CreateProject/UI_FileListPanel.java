package UI_System.CreateProject;

import javax.swing.*;
import java.awt.*;

public class UI_FileListPanel extends JPanel {
    //左下
    public JLabel projectFileLabel=new JLabel();
    public JButton importFileButton=new JButton();
    public  JButton deleteFileButton=new JButton();
    public JTable table=new JTable(4,1);
    public JButton previousPage=new JButton();
    public JTextField pageNumber=new JTextField();
    public JButton nextPage=new JButton();
    //左上
    JLabel projectNameLabel=new JLabel();
    JTextField text1=new JTextField();
    JButton createButton=new JButton();

    JLabel locationPathLabel=new JLabel();
    JTextField text2=new JTextField();
    JButton browerButton=new JButton();
    //右上
    JLabel beginLabel;
    JComboBox beginComboBox;
    JLabel goalLabel;
    JComboBox goalComboBox;



    public UI_FileListPanel()
    {
        this.setLayout(null);
        // this.setBackground(Color.blue);
//左下
        projectFileLabel.setText("项目文件");
        importFileButton.setText("导入文件");
        importFileButton.setMargin(new Insets(0,0,0,0));
        deleteFileButton.setText("删除文件");
        deleteFileButton.setMargin(new Insets(0,0,0,0));
        previousPage.setText("上一页");
        previousPage.setFont(new Font(null, Font.PLAIN,10));
        previousPage.setMargin(new Insets(0,0,0,0 ));
        nextPage.setText("下一页");
        nextPage.setFont(new Font(null, Font.PLAIN,10));
        nextPage.setMargin(new Insets(0,0,0,0));

        pageNumber.setHorizontalAlignment(JTextField.CENTER);

        this.add(projectFileLabel);
        this.add(importFileButton);
        this.add(deleteFileButton);
        this.add(table);
        this.add(previousPage);
        this.add(nextPage);
        this.add(pageNumber);

        projectFileLabel.setBounds(60,230,60,30);
        importFileButton.setBounds(60,260,60,20);
        deleteFileButton.setBounds(130,260,60,20);
        table.setBounds(60,300,180,80);
        previousPage.setBounds(80,400,40,20);
        nextPage.setBounds(170,400,40,20);
        pageNumber.setBounds(130,400,30,20);

//左上
        projectNameLabel.setText("项目名称");
        this.add(projectNameLabel);
        projectNameLabel.setBounds(60,60,60,30);

        this.add(text1);
        text1.setBounds(60,90,200,30);

        createButton.setText("创建");
        this.add(createButton);
        createButton.setMargin(new Insets(0,0,0,0));
        createButton.setBounds(280,90,60,30);

        locationPathLabel.setText("位置路径");
        this.add(locationPathLabel);
        locationPathLabel.setBounds(60,150,60,30);

        this.add(text2);
        text2.setBounds(60,180,200,30);

        browerButton.setText("浏览");
        this.add(browerButton);
        browerButton.setMargin(new Insets(0,0,0,0));
        browerButton.setBounds(280,180,60,30);

        //右上
        beginLabel=new JLabel("源语言");
        goalLabel=new JLabel("目标语言");
        String[] language=new String[]{"English","Chinese"};
        beginComboBox=new JComboBox<>(language);
        goalComboBox=new JComboBox<>(language);

        this.add(beginLabel);
        this.add(goalLabel);
        this.add(beginComboBox);
        this.add(goalComboBox);

        beginLabel.setBounds(400,60,50,30);
        goalLabel.setBounds(400,150,50,30);
        beginComboBox.setBounds(450,60,100,30);
        goalComboBox.setBounds(450,150,100,30);




    }
}