package UI_System;

import javax.swing.*;
import java.awt.*;

public class AssociationWindow extends JFrame {
    public static final int tableRow = 9;
    public JPanel AssociationPanel;
    public JTextField textField;

    public JTable table;
    public JButton formerPageButton;
    public JButton nextPageButton;
    public JButton confirmButton;
    public JLabel bookPrint;

    public static void main(String[] args) {
        AssociationWindow win = new AssociationWindow();
    }

    public AssociationWindow() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("自动完成");
        setBackground(Color.decode("#EAECF2"));
        setResizable(false);

        AssociationPanel = new JPanel();
        AssociationPanel.setLayout(null);

        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        formerPageButton = new JButton("上一页");
        nextPageButton = new JButton("下一页");
        confirmButton = new JButton("确定");

        textField = new JTextField();
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setFocusable(false);
        textField.setEditable(false);

        table = new JTable(tableRow, 1);
        table.setRowHeight(20);
        table.setGridColor(Color.BLACK);

        AssociationPanel.add(textField);
        AssociationPanel.add(table);
        AssociationPanel.add(formerPageButton);
        AssociationPanel.add(nextPageButton);
        AssociationPanel.add(confirmButton);
        AssociationPanel.add(bookPrint);

        textField.setBounds(50, 20, 400, 30);
        table.setBounds(50, 70, 400, 180);

        formerPageButton.setBounds(50, 270, 90, 20);
        nextPageButton.setBounds(205, 270, 90, 20);
        bookPrint.setBounds(165, 270, 40, 20);
        confirmButton.setBounds(350, 270, 90, 20);

        setContentPane(AssociationPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
