/**
 * 类名：UI_MemoryLibraryDetailsPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的记记忆库细节面板，并添加定位相关组件
 */

package UI_System.MemLibWin;

import javax.swing.*;
import java.awt.*;

public class UI_MemoryLibraryDetailsPanel extends JPanel {
    public JLabel label;
    public JTextArea textArea;
    public Color YellowColor = new Color(163, 189, 96);

    public UI_MemoryLibraryDetailsPanel() {
        setLayout(null);

        setBackground(Color.yellow);

        label = new JLabel("项目信息");
        label.setBounds(25, 50, 100, 50);
        add(label);

        textArea = new JTextArea();
        textArea.setBackground(YellowColor);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        add(textArea);

        textArea.setBounds(25,100,150,200);
    }

    public void SetText(String text) {
        textArea.setText(text);
    }
}
