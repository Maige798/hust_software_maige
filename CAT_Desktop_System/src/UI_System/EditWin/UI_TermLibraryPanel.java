package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_TermLibraryPanel extends JPanel {
    public Color DarkBlueColor = new Color(47, 116, 208);
    public Color BlueColor = new Color(140, 240, 240);

    public JTextArea textArea;

    JButton addTermsButton;

    public UI_TermLibraryPanel() {
        setLayout(null);
        setBackground(DarkBlueColor);

        textArea = new JTextArea();
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        addTermsButton = new JButton("添加术语");

        add(textArea);
        add(addTermsButton);

        textArea.setBounds(20, 15, 250, 130);
        addTermsButton.setBounds(180, 150, 90, 20);
    }

    public void SetTextArea(String message) {
        textArea.setText(message);
    }
}
