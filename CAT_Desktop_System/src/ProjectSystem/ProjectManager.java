package ProjectSystem;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;
import SystemUtil.Language;
import SystemUtil.TranslationItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    public static final String fileName = "CAT_System.proj"; // 项目管理器的文件名称
    public static final String listSavePath = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\System_File\\"; // 项目管理器文件的存储路径

    public List<CAT_Project> projectList = new ArrayList<>(); // 项目列表
    public CAT_Project currentProject; // 当前打开的项目
    public TranslationFile currentTranslationFile; // 当前正处于编辑状态的文件

    // 实现单例模式
    public static ProjectManager instance = new ProjectManager();

    private ProjectManager() {
        CAT_FileItem[] items = CAT_FileController.ReadFile(listSavePath + fileName);
        for (CAT_FileItem item : items) {
            if (item.label.equals("Project")) {
                projectList.add(DealWithProjectItem(item));
            }
        }
    }

    // 根据CAT_FileItem信息导入项目
    private static CAT_Project DealWithProjectItem(CAT_FileItem item) {
        if (item.GetLength() == 1) {
            if (!item.GetItem(0).equals("save"))
                System.err.println("Expected<save>, wrong:" + item.GetItem(0));
            return LoadProjectWithoutAdd(item.GetContain(0));
        } else {
            System.err.println("Wrong length of Project item. Length:" + item.GetLength());
            return null;
        }
    }

    // 保存projectList信息
    public static String SaveProjectList() {
        StringBuffer buffer = new StringBuffer();
        for (CAT_Project project : instance.projectList)
            buffer.append(GetProjectMessage(project)).append("\r\n");
        try (FileWriter out = new FileWriter(listSavePath + fileName)) {
            out.write(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    // 将project信息转换成字符串
    private static String GetProjectMessage(CAT_Project project){
        StringBuffer buffer=new StringBuffer("@Project {\r\n");
        buffer.append("\t<save> ").append(project.save).append("\r\n");
        buffer.append("}\r\n");
        return buffer.toString();
    }

    // 新建一个项目，生成对应文件，返回其对象
    public static CAT_Project CreateProject(String name, String save, Language origin,Language target) {
        File outFile = new File(save + name + ".catp");
        try {
            if (!outFile.createNewFile()) {
                System.out.println("File already exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CAT_Project project = new CAT_Project(name, save + name + ".catp", origin, target);
        instance.projectList.add(project);
        SaveProjectList();
        SaveProject(project);
        return project;
    }

    // 导入项目
    public static CAT_Project LoadProject(String save) {
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        CAT_Project project = new CAT_Project(items);
        instance.projectList.add(project);
        return project;
    }

    // 仅在初始化时使用的导入项目，解决instance为null无法添加project问题
    private static CAT_Project LoadProjectWithoutAdd(String save){
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        return new CAT_Project(items);
    }

    public static CAT_Project GetProject(int num) {
        return instance.projectList.get(num);
    }

    public static CAT_Project GetProject(String name) {
        for (CAT_Project project : instance.projectList)
            if (project.name.equals(name))
                return project;
        System.out.println("Could not find project: " + name);
        return null;
    }

    public static void SaveProject(CAT_Project project) {
        System.out.println(project.save);
        try (FileWriter out = new FileWriter(project.save)) {
            out.write(project.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void OpenProject(CAT_Project project) {
        if (instance.currentProject != null)
            SaveProject(instance.currentProject);
        instance.currentProject = project;
    }

    public static void TranslateFile(TranslationFile translationFile) {
        if (instance.currentTranslationFile != null)
            TranslationFileManager.SaveFile(instance.currentTranslationFile);
        instance.currentTranslationFile = translationFile;
    }

    // 将instance.projectList中的全部CAT_Project转换为String提供给WelcomeWindow
    public static String[] SendWelcomeWindowMessage() {
        String[] messages = new String[instance.projectList.size()];
        for (int i = 0; i < instance.projectList.size(); i++) {
            CAT_Project project = instance.projectList.get(i);
            messages[i] = project.name;
        }
        return messages;
    }
}
