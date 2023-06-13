/**
 * 类名：UI_TermLibWin_ContentPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的术语库总内容面板，并合并其余面板，构成展示面板
 */

package UI_System.TermLibWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_TermLibWin_ContentPanel extends JPanel {
    public JFrame frame;

    public UI_TermLibraryListPanel termLibraryListPanel;
    public UI_InterfaceSwitchingPanel interfaceSwitchingPanel;
    public UI_TermLibraryPanel termLibraryPanel;
    public UI_ItemSelectionPanel itemSelectionPanel;
    public UI_TermLibWin_ContentPanel(JFrame frame) {
        this.frame = frame;

        termLibraryListPanel = new UI_TermLibraryListPanel();
        itemSelectionPanel = new UI_ItemSelectionPanel();
        interfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_System.GeneralWin.UI_InterfaceSwitchingPanel.TermLibrary_WIN_Index);
        termLibraryPanel = new UI_TermLibraryPanel();
        itemSelectionPanel.termLibraryPanel=termLibraryPanel;
        termLibraryListPanel.termLibraryPanel=termLibraryPanel;

        setLayout(null);

        add(termLibraryListPanel);
        add(interfaceSwitchingPanel);
        add(termLibraryPanel);
        add(itemSelectionPanel);

        termLibraryListPanel.setBounds(0, 0, 200, 400);
        interfaceSwitchingPanel.setBounds(0, 400, 200, 250);
        termLibraryPanel.setBounds(200, 100, 800, 500);
        itemSelectionPanel.setBounds(200, 0, 800, 150);
    }
}
