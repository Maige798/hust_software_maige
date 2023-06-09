package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_EditorInformationPanel extends JPanel {
    public JLabel label;
    public JTextArea textArea;
    public Color YellowColor = new Color(163, 189, 96);

    public UI_EditorInformationPanel() {

        setLayout(null);

        setBackground(Color.yellow);

        label = new JLabel("项目信息");
        label.setBounds(25, 50, 100, 50);
        add(label);

        textArea = new JTextArea();
        textArea.setBackground(YellowColor);
        textArea.setEditable(false);

        add(textArea);

        textArea.setBounds(25,100,150,200);
    }
}
