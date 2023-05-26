package ProjectSystem;

import MemoryLibrarySystem.MemoryLibraryManager;
import TermLibrarySystem.TermLibraryManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
