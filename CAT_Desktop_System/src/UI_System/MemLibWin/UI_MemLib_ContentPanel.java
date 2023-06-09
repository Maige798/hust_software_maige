package UI_System.MemLibWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_MemLib_ContentPanel extends JPanel {
    public JFrame jFrame;

    //创建翻译记忆库列表
    public JPanel MemoryLibraryListPanel;

    //创建主界面切换栏
    public JPanel InterfaceSwitchingPanel;

    //创建记忆库条目栏
    public UI_MemoryLibraryItemsPanel MemoryLibraryItemsPanel;

    //创建条目筛选栏
    public UI_ItemSelectionPanel ItemSelectionPanel;

    public UI_MemLib_ContentPanel(JFrame frame) {
        MemoryLibraryListPanel = new UI_MemoryLibraryDetailsPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_InterfaceSwitchingPanel.MemoryLibrary_WIN_Index);
        MemoryLibraryItemsPanel = new UI_MemoryLibraryItemsPanel();
        ItemSelectionPanel = new UI_ItemSelectionPanel();
        ItemSelectionPanel.SetItemsPanel(MemoryLibraryItemsPanel);

        setLayout(null);

        add(MemoryLibraryListPanel);
        add(InterfaceSwitchingPanel);
        add(MemoryLibraryItemsPanel);
        add(ItemSelectionPanel);

        MemoryLibraryListPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
        MemoryLibraryItemsPanel.setBounds(200, 100, 800, 500);
        ItemSelectionPanel.setBounds(200, 0, 800, 150);
    }
}
