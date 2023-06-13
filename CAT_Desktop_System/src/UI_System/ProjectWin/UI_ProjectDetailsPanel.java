/**
 * 类名：UI_ProjectDetailsPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计文件框架中的项目信息面板，并添加定位相关组件
 */

package UI_System.ProjectWin;

import javax.swing.*;
import java.awt.*;

public class UI_ProjectDetailsPanel extends JPanel {
    public Color Purple = new Color(155, 144, 225);
    public Color White = new Color(246, 246, 246);

    public JTextArea field;

    public UI_ProjectDetailsPanel() {
        setLayout(null);
        setBackground(Purple);

        field = new JTextArea();

        add(field);

        field.setEditable(false);
        field.setBounds(100, 50, 600, 100);
        field.setDisabledTextColor(White);
    }

    public void SetTextField(String text) {
        field.setText(text);
    }
}
