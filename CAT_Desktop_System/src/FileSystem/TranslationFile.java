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

    // 向paragraphsList中新增一条TranslationItem
    private void DivideNewParagraph(Language language,String text) {
        paragraphsList.add(new TranslationItem(language, text));
    }

    // 根据获取的文本内容生成paragraphList
    public void SetUpParagraphs(String message) {
        char[] messages=message.toCharArray();
        int pointer=0;
        boolean flag = false; // 上一个符号为\r时为true
        StringBuffer buffer = new StringBuffer();
        while (pointer<messages.length) {
            buffer.append(messages[pointer]);
            if (isSeparator(messages[pointer]) == 1) {
                this.DivideNewParagraph(this.originLanguage, buffer.toString());
                buffer.delete(0, buffer.length());
                flag = false;
            } else if (isSeparator(messages[pointer]) == 2 || (isSeparator(messages[pointer]) == 4 && !flag)) {
                buffer.deleteCharAt(buffer.length() - 1);
                if (!buffer.isEmpty()) {
                    this.DivideNewParagraph(this.originLanguage, buffer.toString());
                    buffer.delete(0,buffer.length());
                }
                this.DivideNewParagraph(Language.Default, String.valueOf(messages[pointer]));
                flag = false;
            } else if (isSeparator(messages[pointer]) == 3) {
                buffer.deleteCharAt(buffer.length() - 1);
                if (!buffer.isEmpty()) {
                    this.DivideNewParagraph(this.originLanguage, buffer.toString());
                    buffer.delete(0,buffer.length());
                }
                buffer.delete(0, buffer.length());
                buffer.append(messages[pointer]);
                flag = true;
            } else if (isSeparator(messages[pointer]) == 4 && flag) {
                this.DivideNewParagraph(Language.Default, buffer.toString());
                buffer.delete(0, buffer.length());
                flag = false;
            } else {
                flag = false;
            }
            pointer++;
        }
    }

    // 将paragraphsList中的translation合并为一个
    public String GetMergedParagraphs(){
        StringBuffer buffer=new StringBuffer();
        for(TranslationItem item:this.paragraphsList){
            if(item.translation!=null)
                buffer.append(item.translation.text);
            else
                buffer.append(item.origin.text);
        }
        return buffer.toString();
    }

    // 判断遇到该符号是否需要分段
    private static int isSeparator(char c) {
        return switch (c) {
            case '，', '。', '？', '！', '：', '；', '…',
                    ',', '.', '?', '!', ':', ';' -> 1; // 纯标点符号
            case ' ', '\t' -> 2; // 空格符
            case '\r' -> 3; // 回车符
            case '\n' -> 4; // 换行符
            default -> 0; // 不用分段
        };
    }
}
