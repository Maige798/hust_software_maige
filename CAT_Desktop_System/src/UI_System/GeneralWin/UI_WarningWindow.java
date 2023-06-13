/**
 * 类名：UI_WaringWindow
 * 开发人员：阮泽同
 * 实现功能：工具窗口，用于弹出一个含有指定信息的警告窗口
 */

package UI_System.GeneralWin;

import javax.swing.*;
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
