package javaswing;

import javaswing.GeneralWin.UI_JMenuBar;
import javaswing.TermLibWin.UI_TermLibWin_ContentPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class TermLibraryWindow extends JFrame{
    public JMenuBar menuBar;
    public UI_TermLibWin_ContentPanel TermLibWin_ContentPanel;
    public static void main(String[] args){
        TermLibraryWindow windows = new TermLibraryWindow();
        windows.setVisible(true);
    }
    public TermLibraryWindow()
    {
        init();
    }

    public void init()
    {
        //窗口设置
        setSize(1000,650);
        setTitle("术语库");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        TermLibWin_ContentPanel=new UI_TermLibWin_ContentPanel();

        //创建顶部菜单栏
        menuBar=new UI_JMenuBar();
        setJMenuBar(menuBar);

        setContentPane(TermLibWin_ContentPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
