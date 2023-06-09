/**
 * 类名：UI_ItemSelectionPanel
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，读取用户输入并据此对记忆条目面板的条目进行筛选
 * 2.开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的记忆库条目选择面板，并添加定位相关组件
 */

package UI_System.MemLibWin;

import ProjectSystem.ProjectManager;

import javax.swing.*;
import java.awt.*;

public class UI_ItemSelectionPanel extends JPanel {
    public Color Orange = new Color(246, 154, 113);
    public Color Blue = new Color(64, 0, 128);
    public JLabel label;
    public JLabel origin;
    public JLabel translation;
    public JTextField field1;
    public JTextField field2;
    public JButton selectButton;

    public UI_MemoryLibraryItemsPanel itemsPanel;

    public void SetItemsPanel(UI_MemoryLibraryItemsPanel panel){
        this.itemsPanel=panel;
    }

    public UI_ItemSelectionPanel() {
        setLayout(null);
        setBackground(Orange);

        label = new JLabel("条目筛选");
        label.setFont(new Font("思源黑体", Font.BOLD, 25));
        label.setForeground(Blue);

        origin = new JLabel("原文文本");
        origin.setForeground(Color.BLACK);
        origin.setFont(new Font("思源黑体", Font.BOLD, 20));
        translation = new JLabel("译文文本");
        translation.setForeground(Color.BLACK);
        translation.setFont(new Font("思源黑体", Font.BOLD, 20));

        field1 = new JTextField(8);
        field1.setFont(new Font(null, Font.PLAIN, 20));
        field2 = new JTextField(8);
        field2.setFont(new Font(null, Font.PLAIN, 20));

        selectButton = new JButton("筛选");
        selectButton.addActionListener(e -> {
            itemsPanel.currentMemoryLibraryItems =
                    ProjectManager.instance.currentProject.memoryLibrary.SearchItemByBoth(field1.getText(), field2.getText());
            itemsPanel.UpdateItemTable();
        });

        add(label);
        add(origin);
        add(translation);
        add(field1);
        add(field2);
        add(selectButton);

        label.setBounds(10, 0, 200, 30);
        origin.setBounds(70, 30, 100, 32);
        field1.setBounds(70, 65, 250, 25);
        translation.setBounds(360, 30, 100, 32);
        field2.setBounds(360, 65, 250, 25);
        selectButton.setBounds(650, 40, 100, 30);
    }
}
