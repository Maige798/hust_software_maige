package UI_System.TermLibCre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_TermCreatePanel1 extends JPanel {
    public JLabel termLibNameLabel;
    public JLabel savePathLabel;
    public TextField text1;
    public TextField text2;
    public JButton browerButton;
    public List<String> filePaths;


    public UI_TermCreatePanel1() {
        this.setLayout(null);

        //创建三对标签文本框并设置位置
    termLibNameLabel=new JLabel("术语库创建");
    savePathLabel=new JLabel("存储路径");
       browerButton=new JButton("浏览");
       text1=new TextField();
       text2=new TextField();


        //创建监听器
        browerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_TermCreatePanel1());
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(filePaths.get(0));
                    UpdateSavePathButton(filePaths);
                }

            }
        });

        this.add(termLibNameLabel);
        this.add(savePathLabel);
        this.add(text1);
        this.add(text2);
        this.add(browerButton);


   termLibNameLabel.setBounds(50,50,75,25);
   text1.setBounds(50,75,300,25);
   savePathLabel.setBounds(50,125,75,25);
   text2.setBounds(50,150,300,25);
   browerButton.setBounds(360,150,75,25);
    }

    private void UpdateSavePathButton(List<String> fileNames) {
        text2.setText(filePaths.get(filePaths.size() - 1));
    }
}
