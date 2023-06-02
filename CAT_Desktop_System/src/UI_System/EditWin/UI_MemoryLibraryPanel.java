package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_MemoryLibraryPanel extends JPanel {
    public Color PinkColor = new Color(219, 141, 241);
    public Color BlueColor = new Color(140, 240, 240);
    public JTextArea textArea;
    public JButton applyTranslationResultButton;

    public UI_MemoryLibraryPanel() {
        setLayout(null);
        setBackground(PinkColor);

        textArea = new JTextArea();
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        applyTranslationResultButton = new JButton("应用翻译结果");

        add(textArea);
        add(applyTranslationResultButton);

        textArea.setBounds(20, 15, 460, 130);
        applyTranslationResultButton.setBounds(360, 150, 120, 20);

    }
}
