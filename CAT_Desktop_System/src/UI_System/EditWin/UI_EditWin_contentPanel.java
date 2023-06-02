package UI_System.EditWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_EditWin_contentPanel extends JPanel {
    public UI_ProjectInformationPanel ProjectInformationPanel;
    public UI_InterfaceSwitchingPanel InterfaceSwitchingPanel;
    public UI_EditPanel EditPanel;
    public UI_MemoryLibraryPanel MemoryLibraryPanel;
    public UI_TermLibraryPanel TermLibraryPanel;

    public UI_EditWin_contentPanel() {
        ProjectInformationPanel = new UI_ProjectInformationPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        MemoryLibraryPanel = new UI_MemoryLibraryPanel();
        TermLibraryPanel = new UI_TermLibraryPanel();
        EditPanel = new UI_EditPanel();
        EditPanel.memoryLibraryPanel=MemoryLibraryPanel;

        setLayout(null);

        add(EditPanel);
        add(MemoryLibraryPanel);
        add(TermLibraryPanel);
        add(ProjectInformationPanel);
        add(InterfaceSwitchingPanel);

        EditPanel.setBounds(200, 180, 800, 450);
        MemoryLibraryPanel.setBounds(200, 0, 500, 200);
        TermLibraryPanel.setBounds(700, 0, 300, 200);
        ProjectInformationPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);

    }
}
