/**
 * 类名：UI_MemLib_ContentPanel
 * 开发人员：王琢玉
 * 实现功能：相对于框架独立设计术语库框架中的记忆库总内容面板，并合并其余面板，构成展示面板

 */

package UI_System.MemLibWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_MemLib_ContentPanel extends JPanel {
    public JFrame frame;

    //创建翻译记忆库列表
    public UI_MemoryLibraryDetailsPanel memoryLibraryDetailsPanel;

    //创建主界面切换栏
    public UI_InterfaceSwitchingPanel InterfaceSwitchingPanel;

    //创建记忆库条目栏
    public UI_MemoryLibraryItemsPanel MemoryLibraryItemsPanel;

    //创建条目筛选栏
    public UI_ItemSelectionPanel ItemSelectionPanel;

    public UI_MemLib_ContentPanel(JFrame frame) {
        this.frame = frame;
        memoryLibraryDetailsPanel = new UI_MemoryLibraryDetailsPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_InterfaceSwitchingPanel.MemoryLibrary_WIN_Index);
        MemoryLibraryItemsPanel = new UI_MemoryLibraryItemsPanel(memoryLibraryDetailsPanel);
        ItemSelectionPanel = new UI_ItemSelectionPanel();
        ItemSelectionPanel.SetItemsPanel(MemoryLibraryItemsPanel);

        setLayout(null);

        add(memoryLibraryDetailsPanel);
        add(InterfaceSwitchingPanel);
        add(MemoryLibraryItemsPanel);
        add(ItemSelectionPanel);

        memoryLibraryDetailsPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
        MemoryLibraryItemsPanel.setBounds(200, 100, 800, 500);
        ItemSelectionPanel.setBounds(200, 0, 800, 150);
    }
}
