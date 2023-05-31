package javaswing;
import javaswing.CreateProject.UI_ContentPanel;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JFrame {

    public WelcomeWindow()
    {
        init();
    }

    public void init()
    {
        setSize(350,400);
        setTitle("记忆库导入");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        JPanel contentPanel=new UI_ContentPanel();


        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        WelcomeToUse me=new WelcomeToUse();
//    }

}