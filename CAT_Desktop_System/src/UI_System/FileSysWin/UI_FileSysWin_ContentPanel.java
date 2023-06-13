package UI_System.FileSysWin;

import UI_System.FileSystemWindow;
import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_FileSysWin_ContentPanel extends JPanel {
    public FileSystemWindow frame;

    public UI_FileDetailsPanel FileDetailsPanel;
    public UI_FileListPanel FileListPanel;
    public UI_InterfaceSwitchingPanel InterfaceSwitchingPanel;
    public UI_ProjectInformationPanel ProjectInformationPanel;

    public UI_FileSysWin_ContentPanel(FileSystemWindow frame) {
        this.frame=frame;
        ProjectInformationPanel = new UI_ProjectInformationPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_System.GeneralWin.UI_InterfaceSwitchingPanel.File_WIN_Index);
        FileListPanel = new UI_FileListPanel();
        FileDetailsPanel = new UI_FileDetailsPanel();

        FileListPanel.frame = frame;
        FileListPanel.fileDetailsPanel=FileDetailsPanel;

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
