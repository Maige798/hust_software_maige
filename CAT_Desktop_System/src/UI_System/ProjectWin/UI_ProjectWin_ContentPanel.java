/**
 * 类名：UI_ProjectWin_ContentPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计文件框架中的文件总内容面板，并合并其余面板，构成展示面板
 */

package UI_System.ProjectWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_ProjectWin_ContentPanel extends JPanel {
    public JFrame frame;

    //创建项目信息栏
    public UI_ProjectInformationPanel ProjectInformationPanel;

    //创建主界面切换栏
    public UI_InterfaceSwitchingPanel InterfaceSwitchingPanel;

    //创建文件列表
    public UI_FileListPanel ProjectListPanel;

    //创建文件详情面板
    public UI_ProjectDetailsPanel ProjectDetailsPanel;

    public UI_ProjectWin_ContentPanel(JFrame frame) {
        this.frame = frame;
        //创建项目信息栏
        ProjectInformationPanel = new UI_ProjectInformationPanel();

        //创建主界面切换栏
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_InterfaceSwitchingPanel.Project_WIN_Index);

        //创建文件列表
        ProjectListPanel = new UI_FileListPanel(frame);

        //创建文件详情面板
        ProjectDetailsPanel = new UI_ProjectDetailsPanel();

        ProjectListPanel.projectDetailsPanel=ProjectDetailsPanel;

        setLayout(null);
        add(ProjectListPanel);
        add(ProjectDetailsPanel);
        add(ProjectInformationPanel);
        add(InterfaceSwitchingPanel);

        ProjectListPanel.setBounds(200, 0, 800, 400);
        ProjectDetailsPanel.setBounds(200, 400, 800, 250);
        ProjectInformationPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
    }
}
