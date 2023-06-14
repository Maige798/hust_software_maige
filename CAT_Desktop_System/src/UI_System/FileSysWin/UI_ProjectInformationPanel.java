/**
 * 类名：UI_ProjectInformationPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计文件框架中的项目信息面板，并添加定位相关组件
 */

package UI_System.FileSysWin;

import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;

public class UI_ProjectInformationPanel extends JPanel {
    public JLabel label;
    public JTextArea textArea;
    public Color YellowColor = new Color(163, 189, 96);

    public UI_ProjectInformationPanel() {
        setLayout(null);

        setBackground(Color.yellow);

        label = new JLabel("项目信息");
        label.setBounds(25, 50, 100, 50);
        add(label);

        textArea = new JTextArea();
        textArea.setBackground(YellowColor);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(textArea);

        textArea.setBounds(25,100,150,200);

        SetUpTextArea();
    }

    public void SetUpTextArea(){
        if(ProjectManager.instance.currentProject!=null)
            textArea.setText(ProjectManager.instance.currentProject.GetAttributeMessage());
    }
}
