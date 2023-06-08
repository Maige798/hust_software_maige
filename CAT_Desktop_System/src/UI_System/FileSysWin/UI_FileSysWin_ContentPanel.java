package UI_System.FileSysWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_FileSysWin_ContentPanel extends JPanel {
    public JFrame frame;

    public UI_FileDetailsPanel UI_FileDetailsPanel;
    public UI_FileListPanel UI_FileListPanel;
    public UI_InterfaceSwitchingPanel UI_InterfaceSwitchingPanel;
    public UI_ProjectInformationPanel UI_ProjectInformationPanel;

    public UI_FileSysWin_ContentPanel(JFrame frame) {
        this.frame=frame;
        UI_ProjectInformationPanel = new UI_ProjectInformationPanel();
        UI_InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        UI_FileListPanel = new UI_FileListPanel();
        UI_FileDetailsPanel = new UI_FileDetailsPanel();

        UI_FileListPanel.frame = frame;

        setLayout(null);
        add(UI_FileListPanel);
        add(UI_FileDetailsPanel);
        add(UI_ProjectInformationPanel);
        add(UI_InterfaceSwitchingPanel);

        UI_FileListPanel.setBounds(200, 0, 800, 400);
        UI_FileDetailsPanel.setBounds(200, 400, 800, 250);
        UI_ProjectInformationPanel.setBounds(0, 0, 200, 400);
        UI_InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
    }
}
