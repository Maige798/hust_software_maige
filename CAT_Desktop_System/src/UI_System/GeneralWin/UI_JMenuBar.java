/**
 * 类名：UI_JMenuBar
 * 1.开发人员：阮泽同
 * 实现功能：实现与内核的交互
 * 2.开发人员：刘闯
 * 实现功能：设计、开发与测试顶部导航栏
 */

package UI_System.GeneralWin;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import MemoryLibrarySystem.MemoryLibraryManager;
import ProjectSystem.CAT_Project;
import ProjectSystem.ProjectManager;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;
import UI_System.FileDeriveWindow;
import UI_System.MemoryLibraryImportInterface;
import UI_System.TermLibraryInputInterface;

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
        addMemoryLibraryItem = new JMenuItem("记忆库导入");
        addTermLibraryItem = new JMenuItem("术语库导入");

        add(fileMenu);
        add(projectMenu);

        fileMenu.add(deriveItem);
        fileMenu.add(saveItem);
        projectMenu.add(addMemoryLibraryItem);
        projectMenu.add(addTermLibraryItem);

        deriveItem.addActionListener(e -> OnDeriveItemDown());
        saveItem.addActionListener(e -> OnSaveItemDown());
        addMemoryLibraryItem.addActionListener(e -> OnAddMemoryLibraryItemDown());
        addTermLibraryItem.addActionListener(e -> OnAddTermLibraryItemDown());
    }

    private void OnDeriveItemDown() {
        if (ProjectManager.instance.currentTranslationFile != null)
            new FileDeriveWindow();
        else
            new UI_WarningWindow("Before derive file,\r\nyou have to OPEN a translation file!");
    }

    private void OnSaveItemDown() {
        if (ProjectManager.instance.currentProject != null) {
            CAT_Project project = ProjectManager.instance.currentProject;
            ProjectManager.SaveProject(project);
            if (project.memoryLibrary != null)
                MemoryLibraryManager.SaveLibrary(project.memoryLibrary);
            if (!project.termLibraryList.isEmpty())
                for (TermLibrary library : project.termLibraryList)
                    TermLibraryManager.SaveLibrary(library);
            if (!project.translationFileList.isEmpty())
                for (TranslationFile file : project.translationFileList)
                    TranslationFileManager.SaveFile(file);
            ProjectManager.SaveProjectList();
        }
    }

    private void OnAddMemoryLibraryItemDown(){
        MemoryLibraryImportInterface window=new MemoryLibraryImportInterface();
    }

    private void OnAddTermLibraryItemDown() {
        TermLibraryInputInterface window = new TermLibraryInputInterface();
    }
}
