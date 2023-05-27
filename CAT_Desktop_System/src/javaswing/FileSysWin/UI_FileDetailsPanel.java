package javaswing.FileSysWin;

import javax.swing.*;
import java.awt.*;

public class UI_FileDetailsPanel extends JPanel {
    public Color Purple = new Color(155, 144, 225);
    public JTextField field;
    public UI_FileDetailsPanel() {
        setLayout(null);
        setBackground(Purple);

        field = new JTextField();

        add(field);

        field.setEditable(false);
        field.setBounds(100, 50, 600, 100);
        field.setDisabledTextColor(new Color(246, 246, 246));

    }
}
