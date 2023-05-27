package javaswing.TermLibWin;

import javaswing.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_TermLibWin_ContentPanel extends JPanel {
    public JPanel UI_TermLibraryListPanel;
    public JPanel UI_InterfaceSwitchingPanel;
    public JPanel UI_TermLibraryPanel;
    public JPanel UI_ItemSelectionPanel;
    public UI_TermLibWin_ContentPanel() {
        UI_TermLibraryListPanel = new UI_TermLibraryListPanel();
        UI_ItemSelectionPanel = new UI_ItemSelectionPanel();
        UI_InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        UI_TermLibraryPanel = new UI_TermLibraryPanel();

        setLayout(null);

        add(UI_TermLibraryListPanel);
        add(UI_InterfaceSwitchingPanel);
        add(UI_TermLibraryPanel);
        add(UI_ItemSelectionPanel);

        UI_TermLibraryListPanel.setBounds(0, 0, 200, 400);
        UI_InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
        UI_TermLibraryPanel.setBounds(200, 100, 800, 500);
        UI_ItemSelectionPanel.setBounds(200, 0, 800, 150);
    }
}
