package ProjectSystem;

import FileSystem.TranslationFile;
import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;
import SystemUtil.TranslationItem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    public List<CAT_Project> projectList = new ArrayList<>(); // 项目列表
    public CAT_Project currentProject; // 当前打开的项目
    public TranslationFile currentTranslationFile; // 当前正处于编辑状态的文件
    public TranslationItem paragraph; // 当前正在编辑的段落

    // 实现单例模式
    public static ProjectManager instance = new ProjectManager();

    private ProjectManager() {

    }

    // 新建一个项目
    public static CAT_Project CreateProject(String name,String save) {
        CAT_Project project = new CAT_Project(name, save);
        instance.projectList.add(project);
        return project;
    }

    public static CAT_Project LoadProject (String save) {
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        CAT_Project project=new CAT_Project(items);
        instance.projectList.add(project);
        return project;
    }

    public static CAT_Project GetProject(int num) {
        return instance.projectList.get(num);
    }

    public static void SaveProject(CAT_Project project) {
        try (FileWriter out = new FileWriter(project.save)) {
            out.write(project.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OpenProject(CAT_Project project){
        instance.currentProject=project;
    }

    public static void TranslateFile(TranslationFile translationFile) {
        instance.currentTranslationFile = translationFile;
    }
}
