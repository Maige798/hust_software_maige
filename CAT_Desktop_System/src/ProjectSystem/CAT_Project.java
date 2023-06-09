/**
 * 类名：CAT_Project
 * 开发人员：阮泽同
 * 实现功能：翻译项目的基本属性和方法，包括记忆库、术语库、翻译文件管理等
 */

package ProjectSystem;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import MemoryLibrarySystem.MemoryLibrary;
import MemoryLibrarySystem.MemoryLibraryManager;
import SystemUtil.CAT_FileItem;
import SystemUtil.Language;
import SystemUtil.TermItem;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;

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

    private CAT_Project() {

    }

    public CAT_Project(String name, String save, Language originLanguage, Language targetLanguage) {
        this.name = name;
        this.save = save;
        this.originLanguage = originLanguage;
        this.targetLanguage = targetLanguage;
    }

    public CAT_Project(CAT_FileItem[] items) {
        this.SetUpProject(items);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@Name {\r\n\t<name> ").append(this.name).append("\r\n}\r\n\r\n");
        buffer.append("@Save {\r\n\t<save> ").append(this.save).append("\r\n}\r\n\r\n");
        buffer.append("@Language {\r\n\t").append("<ori> ").append(this.originLanguage).append("\r\n");
        buffer.append("\t<tran> ").append(this.targetLanguage).append("\r\n}\r\n\r\n");
        if (this.memoryLibrary != null)
            buffer.append("@MemLib {\r\n\t<save> ").append(this.memoryLibrary.save).append("\r\n}\r\n\r\n");
        for (TermLibrary termLibrary : termLibraryList)
            buffer.append("@TermLib {\r\n\t<save> ").append(termLibrary.save).append("\r\n}\r\n\r\n");
        for (TranslationFile translationFile : translationFileList)
            buffer.append("@TranFile {\r\n\t<save> ").append(translationFile.save).append("\r\n}\r\n\r\n");
        return buffer.toString();
    }

    // 根据读取的文件条目生成对象
    public void SetUpProject(CAT_FileItem[] items) {
        for (CAT_FileItem item : items) {
            switch (item.label) {
                case "Name" -> this.name = item.GetContain(0);
                case "Save" -> this.save = item.GetContain(0);
                case "Language" -> {
                    if (item.GetItem(0).equals("ori"))
                        this.originLanguage = Language.GetLanguage(item.GetContain(0));
                    else
                        System.err.println("Expected: ori, wrong in TranItem:" + item.GetItem(0));
                    if (item.GetItem(1).equals("tran"))
                        this.targetLanguage = Language.GetLanguage(item.GetContain(1));
                    else
                        System.err.println("Expected: tran, wrong in TranItem:" + item.GetItem(1));
                }
                case "MemLib" -> this.SetMemoryLibrary(MemoryLibraryManager.LoadLibrary(item.GetContain(0)));
                case "TermLib" -> this.AddTermLibrary(TermLibraryManager.LoadLibrary(item.GetContain(0)));
                case "TranFile" -> this.AddTranslationFile(TranslationFileManager.LoadFile(item.GetContain(0)));
                default -> System.err.println("Wrong item:" + item.label);
            }
        }
    }

    public void SetMemoryLibrary(MemoryLibrary library) {
        this.memoryLibrary = library;
    }

    public void AddTermLibrary(TermLibrary library) {
        this.termLibraryList.add(library);
    }

    public void DeleteTermLibrary(TermLibrary library) {
        this.termLibraryList.removeIf(termLibrary -> termLibrary.equals(library));
    }

    public void AddTranslationFile(TranslationFile translationFile) {
        this.translationFileList.add(translationFile);
    }

    public void RemoveTranslationFile(TranslationFile tranFile) {
        this.translationFileList.removeIf(translationFile -> translationFile.equals(tranFile));
    }

    public TranslationFile GetTranslationFile(int num) {
        return translationFileList.get(num);
    }

    public String GetTermLibraryMessages(String text) {
        StringBuffer buffer = new StringBuffer();
        for (TermLibrary library : termLibraryList)
            buffer.append(library.Match(text));
        return buffer.toString();
    }

    public void AddTermToAllTermLibraries(TermItem item) {
        for (TermLibrary library : termLibraryList) {
            library.AddItem(item);
            TermLibraryManager.SaveLibrary(library);
        }
    }

    public String[] GetAllTermLibraryNames() {
        String[] names = new String[termLibraryList.size()];
        for (int i = 0; i < termLibraryList.size(); i++)
            names[i] = termLibraryList.get(i).name;
        return names;
    }

    public String GetAttributeMessage() {
        return "名称：" + this.name + "\r\n"
                + "存储路径：" + this.save + "\r\n"
                + "源语言：" + this.originLanguage.name + "\r\n"
                + "目标语言：" + this.targetLanguage.name + "\r\n";
    }
}
