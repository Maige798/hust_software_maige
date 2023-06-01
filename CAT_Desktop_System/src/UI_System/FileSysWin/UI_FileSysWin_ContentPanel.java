package UI_System.FileSysWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_FileSysWin_ContentPanel extends JPanel {

    public JPanel UI_FileDetailsPanel;
    public JPanel UI_FileListPanel;
    public JPanel UI_InterfaceSwitchingPanel;
    public JPanel UI_ProjectInformationPanel;

    public UI_FileSysWin_ContentPanel() {
        UI_ProjectInformationPanel = new UI_ProjectInformationPanel();
        UI_InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        UI_FileListPanel = new UI_FileListPanel();
        UI_FileDetailsPanel = new UI_FileDetailsPanel();

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
