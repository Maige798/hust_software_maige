package javaswing.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_TermLibraryPanel extends JPanel {
    public Color DarkBlueColor = new Color(47, 116, 208);
    public Color BlueColor = new Color(140, 240, 240);
    public JTextArea textArea;
    JButton jButton;

    public UI_TermLibraryPanel() {
        setLayout(null);
        setBackground(DarkBlueColor);

        textArea = new JTextArea();
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        jButton = new JButton("添加术语");

        add(textArea);
        add(jButton);

        textArea.setBounds(20, 15, 250, 130);
        jButton.setBounds(180, 150, 90, 20);
    }
}
