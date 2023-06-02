package MemoryLibrarySystem;

import SystemUtil.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryLibrary {
    public String name; // 记忆库的名称
    public String save; // 记忆库的存储路径
    public List<TranslationItem> itemsList = new ArrayList<>();

    // 构造方法
    public MemoryLibrary(String save) {
        this.save = save;
        this.name = null;
    }

    public MemoryLibrary(String name,String save) {
        this.name = name;
        this.save = save;
    }

    // 添加一条翻译条目
    public void AddItem(TranslationItem item){
        itemsList.add(item);
    }

    // 按序号删除一条翻译条目
    public void RemoveItem(int num){
        itemsList.remove(num);
    }

    // 删除一条翻译条目
    public void RemoveItem(TranslationItem item) {
        itemsList.removeIf(tran -> tran.equals(item));
    }

    // 编辑一条项目
    public void EditItem(int num, TranslationItem newItem) {
        itemsList.set(num, newItem);
    }

    // 编辑一条项目
    public void EditItem(TranslationItem item,String originText,String translationText){

    }

    // 获取对应序号的条目
    public TranslationItem GetItem(int num){
        return itemsList.get(num);
    }

    // 获取当前记忆库所有条目
    public TranslationItem[] GetAllItems() {
        TranslationItem[] items=new TranslationItem[itemsList.size()];
        itemsList.toArray(items);
        return items;
    }

    // 按照原文筛选条目
    public TranslationItem[] SearchItemByOrigin(String target) {
        List<TranslationItem> targetList = new ArrayList<>();
        for (TranslationItem item : itemsList)
            if (item.origin.text.contains(target))
                targetList.add(item);
        TranslationItem[] translationItems = new TranslationItem[targetList.size()];
        targetList.toArray(translationItems);
        return translationItems;
    }

    // 按照译文筛选条目
    public TranslationItem[] SearchItemByTranslation(String target) {
        List<TranslationItem> targetList = new ArrayList<>();
        for (TranslationItem item : itemsList)
            if (item.translation.text.contains(target))
                targetList.add(item);
        TranslationItem[] translationItems = new TranslationItem[targetList.size()];
        targetList.toArray(translationItems);
        return translationItems;
    }

    // 按照原文和译文筛选条目
    public TranslationItem[] SearchItemByBoth(String originTarget,String TranslationTarget) {
        List<TranslationItem> targetList = new ArrayList<>();
        for (TranslationItem item : itemsList)
            if (item.origin.text.contains(originTarget) && item.translation.text.contains(TranslationTarget))
                targetList.add(item);
        TranslationItem[] translationItems = new TranslationItem[targetList.size()];
        targetList.toArray(translationItems);
        return translationItems;
    }

    // 遍历当前记忆库所有条目，筛选出与text匹配程度最高的条目的translation
    public String Match(String text) {
        if (itemsList.isEmpty())
            return "[Nothing to match]";
        TranslationItem item = itemsList.get(0);
        double maxValue = Similarity(item.origin.text, text);
        for (TranslationItem translationItem : itemsList) {
            if (Similarity(translationItem.origin.text, text) > maxValue) {
                maxValue = Similarity(translationItem.origin.text, text);
                item = translationItem;
            }
        }
        return "MaxValue:" + maxValue + "\n" + item.translation.text;
    }

    // 计算相似度
    private double Similarity(String memory,String text) {
        return (double) new LCS_Helper(memory, text).Get_LCS_Length() / (double) memory.length();
    }

    // 根据获取的存储的信息生成对象（旧方法，暂时弃用）
    public void SetUpLibrary(String message){
        char[] messages=message.toCharArray();
        int pointer=0;
        StringBuilder buffer=new StringBuilder();
        while (pointer<messages.length){
            if (messages[pointer]=='@') {
                pointer++; // 指向@下一个字符
                while (Character.isLetter(messages[pointer])) {
                    buffer.append(messages[pointer]);
                    pointer++;
                }
                if (buffer.toString().equals("TranItem")) { // 匹配到@TranItem
                    TranslationItem item = new TranslationItem();
                    buffer.delete(0, buffer.length());
                    while (messages[pointer]!='<')
                        pointer++; // 省去{至<中的字符
                    pointer++; // 指向<下一个字符
                    while (messages[pointer]!='>') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    if (buffer.toString().equals("ori")) { // 匹配到<ori>
                        buffer.delete(0, buffer.length());
                        while (messages[pointer]!='[')
                            pointer++; // 省去>至[之间的字符]
                        pointer++; // 指向[下一个字符
                        while (messages[pointer]!=']') {
                            buffer.append(messages[pointer]);
                            pointer++;
                        }
                        pointer++;
                        item.origin.language = Language.GetLanguage(buffer.toString());
                        buffer.delete(0, buffer.length());
                        if(messages[pointer]==' ')
                            pointer++; // 省去]与内容之间的空格
                        while (messages[pointer]!='\r') {
                            buffer.append(messages[pointer]);
                            pointer++;
                        }
                        item.origin.text = buffer.toString();
                        buffer.delete(0, buffer.length());
                        while (messages[pointer] != '<' && messages[pointer] != '}')
                            pointer++;
                        if (messages[pointer] == '<') {
                            pointer++;
                            while (messages[pointer] != '>') {
                                buffer.append(messages[pointer]);
                                pointer++;
                            }
                            if (buffer.toString().equals("tran")) { // 匹配到<tran>
                                buffer.delete(0, buffer.length());
                                while (messages[pointer] != '[')
                                    pointer++; // 省去>至[之间的字符]
                                pointer++;
                                while (messages[pointer] != ']') {
                                    buffer.append(messages[pointer]);
                                    pointer++;
                                }
                                pointer++;
                                item.translation.language = Language.GetLanguage(buffer.toString());
                                buffer.delete(0, buffer.length());
                                if(messages[pointer]==' ')
                                    pointer++;
                                while (messages[pointer] != '\r') {
                                    buffer.append(messages[pointer]);
                                    pointer++;
                                }
                                item.translation.text = buffer.toString();
                            } else if (buffer.toString().equals("blank")) {
                                item.translation = null;
                            } else {
                                System.err.println("Wrong in item:" + buffer);
                            }
                        }
                    } else {
                        System.err.println("Wrong in item:" + buffer);
                    }
                    this.itemsList.add(item);
                } else if (buffer.toString().equals("Blank")) { // 匹配到@Blank
                    TranslationItem item = new TranslationItem();
                    item.origin = new Sentence(Language.Default, " ");
                    item.translation = new Sentence(Language.Default, " ");
                    this.itemsList.add(item);
                } else if (buffer.toString().equals("Table")) { // 匹配到@Table
                    TranslationItem item = new TranslationItem();
                    item.origin = new Sentence(Language.Default, "\t");
                    item.translation = new Sentence(Language.Default, "\t");
                    this.itemsList.add(item);
                } else if (buffer.toString().equals("Return")) { // 匹配到@Return
                    TranslationItem item = new TranslationItem();
                    item.origin = new Sentence(Language.Default, "\r\n");
                    item.translation = new Sentence(Language.Default, "\r\n");
                    this.itemsList.add(item);
                } else if (buffer.toString().equals("Name")) { // 匹配到@Name
                    buffer.delete(0, buffer.length());
                    while (messages[pointer] != '{')
                        pointer++; // 省略{
                    pointer++;
                    while (messages[pointer] != '}') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    this.name = buffer.toString();
                } else if (buffer.toString().equals("Save")) { // 匹配到@Save
                    buffer.delete(0, buffer.length());
                    while (messages[pointer] != '{')
                        pointer++; // 省略{
                    pointer++;
                    while (messages[pointer] != '}') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    this.save = buffer.toString();
                } else {
                    System.err.println("Wrong in type:" + buffer);
                }
                buffer.delete(0, buffer.length());
            }
            pointer++;
        }
    }

    // 根据获得的文件条目生成对象
    public void SetUpLibrary(CAT_FileItem[] items) {
        for (CAT_FileItem item : items) {
            switch (item.label) {
                case "Name" -> this.name = item.GetContain(0);
                case "Save" -> this.save = item.GetContain(0);
                case "TranItem" -> {
                    TranslationItem translationItem = new TranslationItem();
                    if (item.GetItem(0).equals("ori"))
                        translationItem.origin = DealWithSentence(item.GetContain(0));
                    else
                        System.err.println("Expected: ori, wrong in TranItem:" + item.GetItem(0));
                    if (item.GetItem(1).equals("tran"))
                        translationItem.translation = DealWithSentence(item.GetContain(1));
                    else
                        System.err.println("Expected: tran, wrong in TransItem:" + item.GetItem(1));
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@Name {\r\n\t<name> ").append(this.name).append("\r\n}\r\n\r\n");
        buffer.append("@Save {\r\n\t<save> ").append(this.save).append("\r\n}\r\n\r\n");
        for (TranslationItem item : this.itemsList) {
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
}
