package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_EditPanel extends JPanel {
    public Color BlueColor = new Color(128, 255, 255);
    public JLabel editLabels0;
    public JLabel editLabels1;
    public JLabel editLabels2;
    public JLabel bookPrint;
    public JLabel[] states;
    public TextField[] texts;
    public JButton btn1;
    public JButton btn2;
    public JButton btn3;
    public JButton btn4;

    public UI_EditPanel() {

        setLayout(null);
        setBackground(BlueColor);

        editLabels0 = new JLabel("原文");
        editLabels0.setForeground(Color.BLACK);
        editLabels1 = new JLabel("状态");
        editLabels1.setForeground(Color.BLACK);
        editLabels2 = new JLabel("译文");
        editLabels2.setForeground(Color.BLACK);
        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        states = new JLabel[8];
        for (int i = 0; i < states.length; i++) {
            states[i] = new JLabel("*");
            states[i].setFont(new Font("宋体", Font.BOLD, 15));
            states[i].setForeground(Color.BLACK);
        }

        texts = new TextField[16];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = new TextField(8);
            texts[i].setFont(new Font(null, Font.PLAIN, 20));
        }

        btn1 = new JButton("确认翻译");
        btn2 = new JButton("开始机械翻译");
        btn3 = new JButton("上一页");
        btn4 = new JButton("下一页");

        add(editLabels0);
        add(editLabels1);
        add(editLabels2);
        add(bookPrint);

        for (JLabel jLabel : states) {
            add(jLabel);
        }

        for (TextField textField : texts) {
            add(textField);
        }

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        editLabels0.setBounds(45, 10, 300, 30);
        editLabels1.setBounds(380, 10, 30, 30);
        editLabels2.setBounds(435, 10, 30, 30);
        bookPrint.setBounds(620, 380, 40, 20);

        int yBegin = 55;
        for (int i = 0; i < states.length; i++) {
            states[i].setBounds(390, yBegin + i * 40, 30, 30);
        }

        int yFirst = 55;
        int ySecond = 55;
        for (int i = 0; i < texts.length; i += 2) {
            texts[i].setBounds(45, yFirst + i * 20, 320, 30);
            texts[i].setEditable(false);
        }
        for (int i = 1; i < texts.length; i += 2) {
            texts[i].setBounds(415, yFirst + (i - 1) * 20, 320, 30);
        }

        btn1.setBounds(485, 15, 100, 20);
        btn2.setBounds(605, 15, 130, 20);
        btn3.setBounds(505, 380, 90, 20);
        btn4.setBounds(665, 380, 90, 20);
    }
}
