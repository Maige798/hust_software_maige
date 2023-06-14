/**
 * 类名：UI_TermLibraryPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计编辑器框架中的术语库协同管理面板，并添加定位相关组件
 */

package UI_System.EditWin;

import UI_System.TermAddWindow;

import javax.swing.*;
import java.awt.*;

public class UI_TermLibraryPanel extends JPanel {
    public Color DarkBlueColor = new Color(47, 116, 208);
    public Color BlueColor = new Color(140, 240, 240);

    public JTextArea textArea;

    public JButton addTermButton;

    public UI_TermLibraryPanel() {
        setLayout(null);
        setBackground(DarkBlueColor);

        textArea = new JTextArea();
        textArea.setBackground(BlueColor);
        textArea.setEditable(false);

        addTermButton = new JButton("添加术语");

        add(textArea);
        add(addTermButton);

        textArea.setBounds(20, 15, 250, 130);
        addTermButton.setBounds(180, 150, 90, 20);
        addTermButton.addActionListener(e -> OnAddTermButtonDown());
    }

    public void SetTextArea(String message) {
        textArea.setText(message);
    }

    private void OnAddTermButtonDown() {
        TermAddWindow window = new TermAddWindow();
    }
}
