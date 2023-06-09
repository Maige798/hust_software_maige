package UI_System.GeneralWin;

import javax.swing.*;

public class UI_JMenuBar extends JMenuBar {
    public JMenu fileMenu;
    public JMenu projectMenu;

    public JMenuItem deriveItem;
    public JMenuItem saveItem;
    public JMenuItem addMemoryLibraryItem;
    public JMenuItem addTermLibraryItem;

    public UI_JMenuBar() {
        fileMenu = new JMenu("文件");
        projectMenu = new JMenu("项目");

        deriveItem = new JMenuItem("导出");
        saveItem = new JMenuItem("保存项目");
        addMemoryLibraryItem = new JMenuItem("添加记忆库");
        addTermLibraryItem = new JMenuItem("添加术语库");

        add(fileMenu);
        add(projectMenu);

        fileMenu.add(deriveItem);
        fileMenu.add(saveItem);
        projectMenu.add(addMemoryLibraryItem);
        projectMenu.add(addTermLibraryItem);

        deriveItem.addActionListener(e -> OnDeriveItemDown());
    }

    private void OnDeriveItemDown() {
        System.out.println("This is file menu");
    }
}
