package javaswing.EditWin;

import javaswing.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_EditWin_contentPanel extends JPanel {
    public JPanel UI_ProjectInformationPanel;
    public JPanel UI_InterfaceSwitchingPanel;
    public JPanel UI_EditPanel;
    public JPanel UI_MemoryLibraryPanel;
    public JPanel UI_TermLibraryPanel;

    public UI_EditWin_contentPanel() {
        UI_ProjectInformationPanel = new UI_ProjectInformationPanel();
        UI_InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        UI_EditPanel = new UI_EditPanel();
        UI_MemoryLibraryPanel = new UI_MemoryLibraryPanel();
        UI_TermLibraryPanel = new UI_TermLibraryPanel();

        setLayout(null);

        add(UI_EditPanel);
        add(UI_MemoryLibraryPanel);
        add(UI_TermLibraryPanel);
        add(UI_ProjectInformationPanel);
        add(UI_InterfaceSwitchingPanel);

        UI_EditPanel.setBounds(200, 180, 800, 450);
        UI_MemoryLibraryPanel.setBounds(200, 0, 500, 200);
        UI_TermLibraryPanel.setBounds(700, 0, 300, 200);
        UI_ProjectInformationPanel.setBounds(0, 0, 200, 400);
        UI_InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);

    }
}
