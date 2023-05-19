package javaswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorWindow extends JFrame{
    public static void main(String[] args){
        EditorWindow win = new EditorWindow();
        win.setVisible(true);
    }
    public EditorWindow(){
        init();
    }

    private Label[] editLabels=new Label[5];

    private void init(){
        //窗口设置
        setTitle("编辑器");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        //创建翻译面板
        JPanel EditPanel = createEditPanel();

        //创建记忆库面板
        JPanel MemoryLibraryPanel=createMemoryLibraryPanel();

        //创建内容面板
        JPanel ContentPanel = new JPanel(new SpringLayout());


        setLocationRelativeTo(null);

    }
    private JPanel createEditPanel(){
        editLabels[0].setText("原文            状态      译文");
        editLabels[0].setForeground(Color.BLACK);
        editLabels[0].setAlignment(3);
        editLabels[1].setText(" ");
        editLabels[2].setText(" ");
        editLabels[3].setText(" ");
        editLabels[4].setText(" ");

        JPanel formerText = new JPanel(new FlowLayout());


        return null;
    }

    private JPanel createMemoryLibraryPanel(){
    return null;
    }

}
