/**
 * 类名：MemoryLibrary
 * 开发人员：阮泽同
 * 实现功能：记忆库基本属性和方法，包括记忆条目增添、删除、编辑、筛选、匹配、初始化等功能
 */

package MemoryLibrarySystem;

import SystemUtil.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryLibrary {
    public String name; // 记忆库的名称
    public String save; // 记忆库的存储路径
    public Language originLanguage; // 原文语言
    public Language translationLanguage; // 译文语言
    public List<TranslationItem> itemsList = new ArrayList<>();

    // 构造方法
    public MemoryLibrary(String save) {
        this.save = save;
        this.name = null;
    }

    public MemoryLibrary(String name,String save,Language originLanguage,Language translationLanguage) {
        this.name = name;
        this.save = save;
        this.originLanguage=originLanguage;
        this.translationLanguage=translationLanguage;
    }

    // 添加一条翻译条目
    public void AddItem(TranslationItem item) {
        for (TranslationItem memItem : itemsList) {
            if (memItem.origin.text.equals(item.origin.text)) {
                memItem.translation.text = item.translation.text;
                return;
            }
        }
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
        item.origin.text=originText;
        item.translation.text=translationText;
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
        double maxValue = new LCS_Helper(item.origin.text,text).GetSimilarity();
        for (TranslationItem translationItem : itemsList) {
            double similarity = new LCS_Helper(translationItem.origin.text, text).GetSimilarity();
            if (similarity > maxValue) {
                maxValue = similarity;
                item = translationItem;
            }
        }
        return "MaxValue:" + maxValue + "\n" + item.translation.text;
    }

    // 根据获得的文件条目生成对象
    public void SetUpLibrary(CAT_FileItem[] items) {
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
                        this.translationLanguage = Language.GetLanguage(item.GetContain(1));
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
        buffer.append("@Language {\r\n\t").append("<ori> ").append(this.originLanguage).append("\r\n");
        buffer.append("\t<tran> ").append(this.translationLanguage).append("\r\n}\r\n\r\n");
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

    public String GetAttributeMessage() {
        return "名称：" + this.name + "\r\n"
                + "存储路径：" + this.save + "\r\n"
                + "源语言：" + this.originLanguage.name + "\r\n"
                + "翻译语言：" + this.translationLanguage + "\r\n"
                + "记忆条目数：" + this.itemsList.size() + "\r\n";
    }
}
