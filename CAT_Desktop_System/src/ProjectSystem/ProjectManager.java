package ProjectSystem;

import FileSystem.TranslationFile;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    public List<CAT_Project> projectList = new ArrayList<>(); // 项目列表
    public CAT_Project currentProject; // 当前打开的项目
    public TranslationFile currentTranslationFile; // 当前正处于编辑状态的文件

    // 实现单例模式
    public static ProjectManager instance = new ProjectManager();

    private ProjectManager() {

    }

    // 新建一个项目
    public CAT_Project CreateProject(String name,String save) {
        CAT_Project project = new CAT_Project(name, save);
        instance.projectList.add(project);
        return project;
    }

    // 根据路径读取一个项目文件，并添加至projectList中
    public CAT_Project ReadProject(String save){
        // todo
        return null;
    }

    public CAT_Project LoadProject () {
        // todo
        return null;
    }

    public void SaveProject(CAT_Project project) {
        // todo
    }

    public void TranslateFile(TranslationFile translationFile) {
        // todo
    }
}
