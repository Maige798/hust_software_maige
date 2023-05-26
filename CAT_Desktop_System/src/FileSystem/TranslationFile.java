package FileSystem;

import SystemUtil.CAT_FileItem;
import SystemUtil.Language;
import SystemUtil.Sentence;
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
    public TranslationFile(){

    }

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

    public void AddItem(TranslationItem item){
        this.paragraphsList.add(item);
    }

    // 翻译某一段话，即设置paragraphsList中的某个成员的translation
    public void TranslateParagraph(int num, String text) {
        if (num > paragraphsList.size()) // 越界报错
            System.err.println("Index out of bounds in paragraphs list of file:" + this.name);
        paragraphsList.get(num).SetTranslation(this.targetLanguage, text);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@Name {\r\n\t<name> ").append(this.name).append("\r\n}\r\n\r\n");
        buffer.append("@Save {\r\n\t<save> ").append(this.save).append("\r\n}\r\n\r\n");
        buffer.append("@Language {\r\n\t").append("<ori> ").append(this.originLanguage).append("\r\n");
        buffer.append("\t<tran> ").append(this.targetLanguage).append("\r\n}\r\n\r\n");
        for (TranslationItem item : this.paragraphsList) {
            if (item.origin.language.EqualsTo(Language.Default)) {
                switch (item.origin.text) {
                    case " " -> buffer.append("@Blank\r\n\r\n");
                    case "\t" -> buffer.append("@Table\r\n\r\n");
                    case "\r\n" -> buffer.append("@Return\r\n\r\n");
                    default -> System.err.println("Wrong in text of Default kind:" + item.origin.text);
                }
            } else {
                buffer.append(item).append("\r\n");
            }
        }
        return buffer.toString();
    }

    // 保存文件
    public void SaveFile() {

    }

    // 根据读取的条目信息初始化对象
    public void SetUpTranslationFile(CAT_FileItem[] items) {
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
                case "TranItem" -> {
                    TranslationItem translationItem = new TranslationItem();
                    if (item.GetItem(0).equals("ori"))
                        translationItem.origin = DealWithSentence(item.GetContain(0));
                    else
                        System.err.println("Expected: ori, wrong in TranItem:" + item.GetItem(0));
                    if (item.GetItem(1).equals("tran"))
                        translationItem.translation = DealWithSentence(item.GetContain(1));
                    else if (item.GetItem(1).equals("blank"))
                        translationItem.translation = null;
                    else
                        System.err.println("Expected: tran, wrong in TransItem:" + item.GetItem(1));
                    this.AddItem(translationItem);
                }
                case "Blank" -> {
                    TranslationItem translationItem = new TranslationItem();
                    translationItem.origin = new Sentence(Language.Default, " ");
                    translationItem.translation = new Sentence(Language.Default, " ");
                    this.AddItem(translationItem);
                }
                case "Table" -> {
                    TranslationItem translationItem = new TranslationItem();
                    translationItem.origin = new Sentence(Language.Default, "\t");
                    translationItem.translation = new Sentence(Language.Default, "\t");
                    this.AddItem(translationItem);
                }
                case "Return" -> {
                    TranslationItem translationItem = new TranslationItem();
                    translationItem.origin = new Sentence(Language.Default, "\r\n");
                    translationItem.translation = new Sentence(Language.Default, "\r\n");
                    this.AddItem(translationItem);
                }
                default -> System.err.println("Wrong item:" + item.label);
            }
        }
    }

    // 根据条目内容，拆分language和text生成一个Sentence
    private static Sentence DealWithSentence(String message) {
        Sentence sentence=new Sentence();
        String[] strings=BreakSentence(message); // 这里strings.length必定为2
        sentence.language=Language.GetLanguage(strings[0]);
        sentence.text=strings[1];
        return sentence;
    }

    // 将信息中的[语言]与内容分开
    private static String[] BreakSentence(String message){
        String[] results=new String[2];
        char[] messages=message.toCharArray();
        int pointer=0;
        while (messages[pointer]!=' ')
            pointer++;
        results[0]=message.substring(1,pointer-1);
        results[1]=message.substring(pointer+1);
        return results;
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

    // 将paragraphsList中的translation合并为一个字符串
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
