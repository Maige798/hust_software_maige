/**
 * 类名：UI_FileDetailsPanel
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System.FileSysWin;

import javax.swing.*;
import java.awt.*;

public class UI_FileDetailsPanel extends JPanel {
    public Color Purple = new Color(155, 144, 225);
    public JTextArea field;

    public UI_FileDetailsPanel() {
        setLayout(null);
        setBackground(Purple);

        field = new JTextArea();

        add(field);

        field.setEditable(false);
        field.setBounds(100, 50, 600, 100);
        field.setDisabledTextColor(new Color(246, 246, 246));
    }

    public void SetText(String message) {
        field.setText(message);
    }
}
