/**
 * 类名：UI_EditorSpellCheckPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计编辑器框架中的拼写检查面板，并添加定位相关组件
 */

package UI_System.EditWin;

import javax.swing.*;
import java.awt.*;

public class UI_EditorSpellCheckPanel extends JPanel {
    public JLabel label;
    public JTextArea textArea;
    public Color YellowColor = new Color(163, 189, 96);

    public UI_EditorSpellCheckPanel() {

        setLayout(null);

        setBackground(Color.yellow);

        label = new JLabel("拼写检查");
        label.setBounds(25, 50, 100, 50);
        add(label);

        textArea = new JTextArea();
        textArea.setBackground(YellowColor);
        textArea.setEditable(false);

        add(textArea);

        textArea.setBounds(25, 100, 150, 200);
    }

    public void SetText(String text) {
        textArea.setText(text);
    }
}
