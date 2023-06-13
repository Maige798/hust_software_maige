/**
 * 类名：UI_ItemSelectionPanel
 * 1.开发人员：阮泽同
 * 实现功能：与术语库面板交互，筛选条目
 * 2.开发人员：
 * 实现功能：
 */

package UI_System.TermLibWin;

import javax.swing.*;
import java.awt.*;

public class UI_ItemSelectionPanel extends JPanel {
    public UI_TermLibraryPanel termLibraryPanel;

    public Color Orange = new Color(246, 154, 113);
    public Color Blue = new Color(64, 0, 128);

    public JLabel label;

    public JTextField textField;
    public JButton selectButton;

    public UI_ItemSelectionPanel() {
        setLayout(null);
        setBackground(Orange);

        label = new JLabel("条目筛选");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);

        textField = new JTextField(8);
        textField.setFont(new Font(null, Font.PLAIN, 20));

        selectButton = new JButton("筛选");
        selectButton.addActionListener(e -> OnSelectButtonDown());

        add(label);
        add(textField);
        add(selectButton);

        label.setBounds(10, 0, 200, 30);
        textField.setBounds(140, 40, 300, 30);
        selectButton.setBounds(500, 40, 100, 30);
    }

    private void OnSelectButtonDown(){
        String text=textField.getText();
        termLibraryPanel.UpdateMessagesByCurrentLibrary(text);
        termLibraryPanel.UpdateTableItems();
    }
}
