package javaswing.TermLibWin;

import javax.swing.*;
import java.awt.*;

public class UI_TermLibraryPanel extends JPanel {
    public Color Green = new Color(204, 255, 128);
    public Color Blue = new Color(64, 0, 128);
    public JLabel label;
    public JLabel bookPrint;
    public JTable table;
    public JButton btn1;
    public JButton btn4;
    public JButton btn2;
    public JButton btn3;
    public JButton formerPage;
    public JButton nextPage;
    public UI_TermLibraryPanel() {
        setLayout(null);
        setBackground(Green);

        label = new JLabel("术语库条目");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);
        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        table = new JTable(18, 2);
        table.setRowHeight(21);
        table.setGridColor(new Color(192, 192, 192));
        table.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        btn1 = new JButton("修改");
        btn4 = new JButton("删除");
        btn2 = new JButton("取消更改");
        btn3 = new JButton("保存更改");

        formerPage = new JButton("上一页");
        nextPage = new JButton("下一页");

        add(label);
        add(bookPrint);
        add(table);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(formerPage);
        add(nextPage);

        label.setBounds(10, 5, 200, 40);
        bookPrint.setBounds(660, 450, 40, 20);
        table.setBounds(30, 50, 740, 378);
        formerPage.setBounds(570, 450, 80, 20);
        nextPage.setBounds(690, 450, 80, 20);
        btn1.setBounds(90, 450, 90, 20);
        btn2.setBounds(310, 450, 90, 20);
        btn3.setBounds(420, 450, 90, 20);
        btn4.setBounds(200, 450, 90, 20);
    }
}
