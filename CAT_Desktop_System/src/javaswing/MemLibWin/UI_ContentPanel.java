package javaswing.MemLibWin;

import javaswing.GeneralWin.UI_InterfaceSwitchingPanel;
import javaswing.MemoryLibraryWindow;

import javax.swing.*;

public class UI_ContentPanel extends JPanel {

    //创建翻译记忆库列表
    public JPanel MemoryLibraryListPanel;

    //创建主界面切换栏
    public JPanel InterfaceSwitchingPanel;

    //创建记忆库条目栏
    public UI_MemoryLibraryItemsPanel MemoryLibraryItemsPanel;

    //创建条目筛选栏
    public UI_ItemSelectionPanel ItemSelectionPanel;

    public UI_ContentPanel() {
        MemoryLibraryListPanel = new UI_MemoryLibraryListPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel();
        MemoryLibraryItemsPanel = new UI_MemoryLibraryItemsPanel();
        ItemSelectionPanel = new UI_ItemSelectionPanel();
        ItemSelectionPanel.itemsPanel=MemoryLibraryItemsPanel;

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
