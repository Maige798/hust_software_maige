package javaswing.TermLibWin;

import javax.swing.*;
import java.awt.*;

public class UI_ItemSelectionPanel extends JPanel {
    public Color Orange = new Color(246, 154, 113);
    public Color Blue = new Color(64, 0, 128);
    public JLabel label;
    public JTextField field1;
    public JButton selectButton;

    public UI_ItemSelectionPanel() {
        setLayout(null);
        setBackground(Orange);

        label = new JLabel("条目筛选");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);

        field1 = new JTextField(8);
        field1.setFont(new Font(null, Font.PLAIN, 20));

        selectButton = new JButton("筛选");

        add(label);
        add(field1);
        add(selectButton);

        label.setBounds(10, 0, 200, 30);
        field1.setBounds(140, 40, 300, 30);
        selectButton.setBounds(500, 40, 100, 30);
    }
}
