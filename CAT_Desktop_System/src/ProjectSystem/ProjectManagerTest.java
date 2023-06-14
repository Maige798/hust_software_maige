/**
 * 类名：ProjectManagerTest
 * 测试：项目载入与项目列表读取
 */

package ProjectSystem;

import MemoryLibrarySystem.MemoryLibraryManager;
import TermLibrarySystem.TermLibraryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectManagerTest {

    @Test
    void loadProject() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\ProjectSystem\\MyProject.catp";
        String source= SystemUtil.Test.GetText(myFile);
        CAT_Project project= ProjectManager.LoadProject(myFile);
        System.out.println("Memory library:\n"+ MemoryLibraryManager.GetMemoryLibrary(0));
        System.out.println("Term library:\n"+ TermLibraryManager.GetTermLibrary(0));
        System.out.println("TranslationFile:\n"+project.translationFileList.get(0));
        assertEquals(source,project.toString());
    }

    @Test
    void readProjectList() {
        for (CAT_Project project : ProjectManager.instance.projectList)
            System.out.println(project);
        String source = SystemUtil.Test.GetText(ProjectManager.listSavePath + ProjectManager.fileName);
        String result = ProjectManager.SaveProjectList();
        assertEquals(source, result);
    }
}
