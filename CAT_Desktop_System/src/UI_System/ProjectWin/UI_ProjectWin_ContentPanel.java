package UI_System.ProjectWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_ProjectWin_ContentPanel extends JPanel {
    public JFrame frame;

    //创建项目信息栏
    public JPanel ProjectInformationPanel;

    //创建主界面切换栏
    public JPanel InterfaceSwitchingPanel;

    //创建文件列表
    public JPanel ProjectListPanel;

    //创建文件详情面板
    public JPanel ProjectDetailsPanel;

    public UI_ProjectWin_ContentPanel(JFrame frame) {
        this.frame=frame;
        //创建项目信息栏
        ProjectInformationPanel = new UI_ProjectInformationPanel();

        //创建主界面切换栏
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame,UI_InterfaceSwitchingPanel.Project_WIN_Index);

        //创建文件列表
        ProjectListPanel = new UI_FileListPanel(frame);

        //创建文件详情面板
        ProjectDetailsPanel = new UI_FileDetailsPanel();

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
