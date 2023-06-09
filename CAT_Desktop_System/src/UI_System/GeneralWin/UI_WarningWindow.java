package UI_System.GeneralWin;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class UI_WarningWindow extends JFrame {
    public JTextArea text;
    public JPanel panel;

    public UI_WarningWindow(String text) {
        this.text = new JTextArea();
        this.text.setText(text);
        this.panel = new JPanel();
        setContentPane(panel);
        panel.add(this.text);

        this.text.setPreferredSize(new Dimension(300, 220));
        this.text.setEditable(false);
        this.text.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.text.setLineWrap(true);
        this.text.setWrapStyleWord(true);

        setTitle("Warning");
        setSize(320, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
