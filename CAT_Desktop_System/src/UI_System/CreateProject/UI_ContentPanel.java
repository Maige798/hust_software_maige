/**
 * 类名：UI_ContentPanel
 * 开发人员：刘闯
 * 实现功能：实现创建项目界面内容面板
 */

package UI_System.CreateProject;

import javax.swing.*;

public class UI_ContentPanel extends JPanel {
    public JFrame frame;

    public UI_FileListPanel panel2 = new UI_FileListPanel();

    public UI_ContentPanel() {
        this.setLayout(null);

        this.add(panel2);
        panel2.frame = this.frame;

        panel2.setBounds(0, 0, 750, 500);
    }
}
