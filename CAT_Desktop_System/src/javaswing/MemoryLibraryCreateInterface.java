package javaswing;


import javaswing.MemoryLibraryCreateWin.UI_MemoryLibraryCreatePanel;

import javax.swing.*;

public class MemoryLibraryCreateInterface extends JFrame {

    public MemoryLibraryCreateInterface()
    {init();}

    public void init()
    {
        setSize(600,350);
        setTitle("记忆库创建");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        JPanel panel=new UI_MemoryLibraryCreatePanel();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        MemoryLibraryCreateInterface me=new MemoryLibraryCreateInterface();
    }
}
