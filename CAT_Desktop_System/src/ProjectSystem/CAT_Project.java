package ProjectSystem;

import FileSystem.TranslationFile;
import MemoryLibrarySystem.MemoryLibrary;
import SystemUtil.Language;
import TermLibrarySystem.TermLibrary;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class CAT_Project {
    public String name; // 项目名称
    public String save; // 项目文件存储路径
    public Language originLanguage; // 项目原文语言
    public Language targetLanguage; // 项目译文语言
    public MemoryLibrary memoryLibrary; // 项目使用的术语库
    public List<TermLibrary> termLibraryList = new ArrayList<>(); // 项目使用的术语库列表
    public List<TranslationFile> translationFileList = new ArrayList<>(); // 项目的翻译文件列表

    // Getters and Setters
    private CAT_Project() {

    }

    public CAT_Project(String name,String save) {
        this.name = name;
        this.save = save;
    }

    public void Save() {
        // todo
    }

    public void SetMemoryLibrary(MemoryLibrary library) {
        // todo
    }

    public void AddTermLibrary(TermLibrary library) {
        // todo
    }

    public void DeleteTermLibrary(TermLibrary library) {
        // todo
    }

    public void AddTranslationFile(TranslationFile translationFile) {
        // todo
    }

    public void RemoveTranslationFile(TranslationFile translationFile) {
        // todo
    }
}
