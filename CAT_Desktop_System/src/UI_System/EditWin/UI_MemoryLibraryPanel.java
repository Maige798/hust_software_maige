/**
 * 类名：
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_MemoryLibraryPanel extends JPanel {
    public UI_EditPanel editPanel;

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
        applyTranslationResultButton.addActionListener(e -> OnApplyTranslationResultButtonDown());

        add(textArea);
        add(applyTranslationResultButton);

        textArea.setBounds(20, 15, 460, 130);
        applyTranslationResultButton.setBounds(360, 150, 120, 20);
    }

    public void SetTextArea(String message) {
        textArea.setText(message);
    }

    public void OnApplyTranslationResultButtonDown() {
        editPanel.UseTranslateResult(GetPrueMatchedMessage());
    }

    private String GetPrueMatchedMessage() {
        String[] results = textArea.getText().split("\n");
        return results[results.length - 1];
    }
}
