package ProjectSystem;

import FileSystem.TranslationFile;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    public List<CAT_Project> projectList = new ArrayList<>();
    // 实现单例模式
    public static ProjectManager instance = new ProjectManager();

    private ProjectManager() {

    }

    public CAT_Project CreateProject(String name) {
        // todo
        return null;
    }

    public void LoadProject(CAT_Project project) {
        // todo
    }

    public void SaveProject(CAT_Project project) {
        // todo
    }

    public void TranslateFile(TranslationFile translationFile) {
        // todo
    }
}
