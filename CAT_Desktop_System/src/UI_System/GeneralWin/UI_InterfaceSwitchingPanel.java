/**
 * 类名：UI_InterfaceSwitchingPanel
 * 开发人员：阮泽同
 * 实现功能：页面切换功能
 */

package UI_System.GeneralWin;

import ProjectSystem.ProjectManager;
import UI_System.*;

import javax.swing.*;
import java.awt.*;

public class UI_InterfaceSwitchingPanel extends JPanel {
    public static final int Project_WIN_Index = 0;
    public static final int File_WIN_Index = 1;
    public static final int Editor_WIN_Index = 2;
    public static final int MemoryLibrary_WIN_Index = 3;
    public static final int TermLibrary_WIN_Index = 4;

    public int currentWindow;

    public JFrame frame;

    public JList<String> list2;

    public UI_InterfaceSwitchingPanel(JFrame frame, int currentWindow) {
        this.frame = frame;
        this.currentWindow = currentWindow;

        list2 = new JList<>();

        // 设置一下首选大小
        list2.setPreferredSize(new Dimension(200, 250));

        // 允许可间断的多选
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 设置选项数据（内部将自动封装成 ListModel ）
        list2.setListData(new String[]{"项目", "文件", "编辑器", "翻译记忆库", "术语库"});

        //设置单元格大小
        list2.setFixedCellWidth(200);
        list2.setFixedCellHeight(35);

        //设置单元格文字居中
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        list2.setCellRenderer(renderer);

        // 设置默认选中项
        list2.setSelectedIndex(currentWindow);

        // 添加选项选中状态被改变的监听器
        list2.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = list2.getSelectedIndex();
                if (index != currentWindow) {
                    switch (index) {
                        case Project_WIN_Index -> ChangeToProjectWindow();
                        case File_WIN_Index -> ChangeToFileWindow();
                        case Editor_WIN_Index -> ChangeToEditorWindow();
                        case MemoryLibrary_WIN_Index -> ChangeToMemoryLibraryWindow();
                        case TermLibrary_WIN_Index -> ChangeToTermLibraryWindow();
                        default -> System.err.println("Wrong list index in InterfaceSwitching panel! " + index);
                    }
                }
            }
        });

        //将list2添加到panel2中
        add(list2);
    }

    private void ChangeToProjectWindow() {
        ProjectWindow window = new ProjectWindow();
        frame.dispose();
    }

    private void ChangeToFileWindow() {
        FileSystemWindow window = new FileSystemWindow();
        frame.dispose();
    }

    private void ChangeToEditorWindow() {
        if (ProjectManager.instance.currentTranslationFile != null) {
            EditorWindow window = new EditorWindow();
            frame.dispose();
        } else {
            UI_WarningWindow warningWindow = new UI_WarningWindow("Before enter Editor Window,\r\nyou have to OPEN a translation file!");
            list2.setSelectedIndex(currentWindow);
        }
    }

    private void ChangeToMemoryLibraryWindow() {
        MemoryLibraryWindow window = new MemoryLibraryWindow();
        frame.dispose();
    }

    private void ChangeToTermLibraryWindow() {
        TermLibraryWindow window = new TermLibraryWindow();
        frame.dispose();
    }
}
