/**
 * 类名：AssociationWindow
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，获取并以当前文本为信息，在字典中匹配的单词，实现与编辑界面交互并自动完成（填入联想词汇）的功能
 * 2.开发人员：王琢玉
 * 实现功能：设计基本页面，包含框架，面板和基本组件，并完成页面转换功能
 */

package UI_System;

import TranslationSystem.EditHelper;
import UI_System.EditWin.UI_EditPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class AssociationWindow extends JFrame {
    public static final int tableRow = 9;

    public UI_EditPanel editPanel;

    public JPanel AssociationPanel;
    public JTextField textField;

    public String message;
    public String[] words;
    public int currentPageNum = 0;
    public JTable table;

    public JButton formerPageButton;
    public JButton nextPageButton;
    public JButton confirmButton;
    public JLabel bookPrint;

    public static void main(String[] args) {
        AssociationWindow win = new AssociationWindow(null,"Remember,li");
    }

    public AssociationWindow(UI_EditPanel editPanel,String message) {
        this.message = message;
        this.words = EditHelper.GetEnglishAssociationWords(message);
        this.editPanel = editPanel;
        init();
        UpdateTable();
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
        textField.setText(message);

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
        formerPageButton.addActionListener(e -> OnFormerPageButtonDown());
        nextPageButton.setBounds(205, 270, 90, 20);
        nextPageButton.addActionListener(e -> OnNextPageButtonDown());

        bookPrint.setBounds(165, 270, 40, 20);

        confirmButton.setBounds(350, 270, 90, 20);
        confirmButton.addActionListener(e -> OnConfirmButtonDown());

        setContentPane(AssociationPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String[] GetCurrentPageWords() {
        return Arrays.copyOfRange(words, currentPageNum * tableRow, Integer.min((currentPageNum + 1) * tableRow, words.length));
    }

    private void UpdateTable() {
        String[] currentPageWords = GetCurrentPageWords();
        for (int i = 0; i < tableRow; i++)
            table.setValueAt("", i, 0);
        for (int i = 0; i < currentPageWords.length; i++)
            table.setValueAt(currentPageWords[i], i, 0);
        UpdateBookPrint();
    }

    private void UpdateBookPrint() {
        bookPrint.setText((currentPageNum + 1) + "/" + ((words.length - 1) / tableRow + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPageNum > 0)
            currentPageNum--;
        UpdateTable();
    }

    private void OnNextPageButtonDown() {
        if (currentPageNum < (words.length - 1) / tableRow)
            currentPageNum++;
        UpdateTable();
    }

    private void OnConfirmButtonDown() {
        editPanel.AutoComplete(words[currentPageNum * tableRow + table.getSelectedRow()]);
        dispose();
    }
}
