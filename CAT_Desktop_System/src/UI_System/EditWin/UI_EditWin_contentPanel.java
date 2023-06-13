/**
 * 类名：UI_EditWin_contentPanel
 * 1.开发人员：
 * 实现功能：
 * 2.开发人员：
 * 实现功能：
 */

package UI_System.EditWin;

import UI_System.GeneralWin.UI_InterfaceSwitchingPanel;

import javax.swing.*;

public class UI_EditWin_contentPanel extends JPanel {
    public JFrame frame;
    public UI_EditorSpellCheckPanel EditorSpellCheckPanel;
    public UI_InterfaceSwitchingPanel InterfaceSwitchingPanel;
    public UI_EditPanel EditPanel;
    public UI_MemoryLibraryPanel MemoryLibraryPanel;
    public UI_TermLibraryPanel TermLibraryPanel;

    public UI_EditWin_contentPanel(JFrame frame) {
        this.frame = frame;
        EditorSpellCheckPanel = new UI_EditorSpellCheckPanel();
        InterfaceSwitchingPanel = new UI_InterfaceSwitchingPanel(frame, UI_InterfaceSwitchingPanel.Editor_WIN_Index);
        MemoryLibraryPanel = new UI_MemoryLibraryPanel();
        TermLibraryPanel = new UI_TermLibraryPanel();
        EditPanel = new UI_EditPanel();
        EditPanel.memoryLibraryPanel = MemoryLibraryPanel;
        EditPanel.termLibraryPanel = TermLibraryPanel;
        EditPanel.spellCheckPanel= EditorSpellCheckPanel;
        MemoryLibraryPanel.editPanel = EditPanel;

        setLayout(null);

        add(EditPanel);
        add(MemoryLibraryPanel);
        add(TermLibraryPanel);
        add(EditorSpellCheckPanel);
        add(InterfaceSwitchingPanel);

        EditPanel.setBounds(200, 180, 800, 450);
        MemoryLibraryPanel.setBounds(200, 0, 500, 200);
        TermLibraryPanel.setBounds(700, 0, 300, 200);
        EditorSpellCheckPanel.setBounds(0, 0, 200, 400);
        InterfaceSwitchingPanel.setBounds(0, 400, 200, 250);
    }
}
