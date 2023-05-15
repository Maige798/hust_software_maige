package FileSystem;

import SystemUtil.Language;
import SystemUtil.TranslationItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TranslationFile {
    public String name; // 文件名称
    public String save; // 文件路径
    public File sourceFile; // 源文件
    public Language originLanguage; // 原文语言
    public Language targetLanguage; // 目标语言
    public List<TranslationItem> paragraphsList = new ArrayList<>();

    // 构造方法
    public TranslationFile(String name, String save, File sourceFile, Language originLanguage, Language targetLanguage) {
        this.name = name;
        this.save = save;
        this.sourceFile = sourceFile;
        this.originLanguage = originLanguage;
        this.targetLanguage = targetLanguage;
    }

    public TranslationFile(String name, String save, String filePath, Language originLanguage, Language targetLanguage) {
        this.name = name;
        this.save = save;
        this.sourceFile = new File(filePath);
        this.originLanguage = originLanguage;
        this.targetLanguage = targetLanguage;
    }

    // 翻译某一段话，即设置paragraphsList中的某个成员的translation
    public void TranslateParagraph(int num, String text) {
        if (num > paragraphsList.size()) // 越界报错
            System.err.println("Index out of bounds in paragraphs list of file:" + this.name);
        paragraphsList.get(num).SetTranslation(this.targetLanguage, text);
    }

    // 保存文件
    public void SaveFile() {
        // todo
    }
}
