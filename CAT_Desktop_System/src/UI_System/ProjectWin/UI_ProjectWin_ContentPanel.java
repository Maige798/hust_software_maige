package UI_System.ProjectWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_ProjectWin_ContentPanel extends JPanel {

    //创建项目信息栏
    public JPanel ProjectInformationPanel;

    //创建主界面切换栏
    public JPanel InterfaceSwitchingPanel;

    //创建文件列表
    public JPanel FileListPanel;

    //创建文件详情面板
    public JPanel FileDetailsPanel;

    public UI_ProjectWin_ContentPanel() {
        //创建项目信息栏
        ProjectInformationPanel = new UI_ProjectInformationPanel();

        //创建主界面切换栏
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();

        //创建文件列表
        FileListPanel = new UI_FileListPanel();

        //创建文件详情面板
        FileDetailsPanel = new UI_FileDetailsPanel();

        setLayout(null);
        add(FileListPanel);
        add(FileDetailsPanel);
        add(ProjectInformationPanel);
        add(InterfaceSwitchingPanel);

        FileListPanel.setBounds(200, 0, 800, 400);
        FileDetailsPanel.setBounds(200, 400, 800, 250);
        ProjectInformationPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);

    }
}
