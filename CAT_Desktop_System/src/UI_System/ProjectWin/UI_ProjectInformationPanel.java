package UI_System.ProjectWin;

import javax.swing.*;
import java.awt.*;

public class UI_ProjectInformationPanel extends JPanel {
    public JTextField field;
    public JButton btn;
    public UI_ProjectInformationPanel() {
        setLayout(null);
        setBackground(Color.yellow);

        field = new JTextField();
        btn = new JButton("查找项目");

        add(field);
        add(btn);

        field.setBounds(30,120,140,40);
        btn.setBounds(50,200,100,40);
    }
}
