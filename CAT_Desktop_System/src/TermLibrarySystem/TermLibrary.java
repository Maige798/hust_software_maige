/**
 * 类名：TermLibrary
 * 开发人员：阮泽同
 * 实现功能：术语库基本属性和方法，包括术语条目增添、删除、编辑、筛选、匹配、初始化等功能
 */

package TermLibrarySystem;

import SystemUtil.*;

import java.util.ArrayList;
import java.util.List;

public class TermLibrary {
    public String name; // 术语库的名称
    public String save; // 术语库的存储路径
    public List<TermItem> itemsList;

    // 构造方法
    public TermLibrary(String Name, String Save) {
        this.name = Name;
        this.save = Save;
        this.itemsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@Name {\r\n\t<name> ").append(this.name).append("\r\n}\r\n\r\n");
        buffer.append("@Save {\r\n\t<save> ").append(this.save).append("\r\n}\r\n\r\n");
        for (TermItem item : this.itemsList)
            buffer.append(item).append("\r\n");
        return buffer.toString();
    }

    // 添加一条术语条目，若存在相同title则合并术语条目
    public void AddItem(TermItem termItem) {
        for (TermItem item : itemsList) {
            if (item.title.equals(termItem.title)) {
                item.Merge(termItem);
                return;
            }
        }
        itemsList.add(termItem);
    }

    // 删除一条术语条目
    public void RemoveItem(TermItem termItem) {
        itemsList.removeIf(term -> term.equals(termItem));
    }

    // 删除与title相同的术语条目
    public void RemoveItem(String title) {
        itemsList.removeIf(item -> item.title.equals(title));
    }

    // 编辑一条术语条目
    public void EditItem(int num, TermItem newItem) {
        itemsList.set(num, newItem);
    }

    // 返回第一个符合title的TermItem
    public TermItem GetItem(String title) {
        for (TermItem item : this.itemsList)
            if (item.title.equals(title))
                return item;
        return null;
    }

    public TermItem GetItem(int num) {
        return itemsList.get(num);
    }

    // 寻找包含目标字符串的全部术语条目
    public TermItem[] SearchItem(String target) {
        List<TermItem> targetList = new ArrayList<>();
        for (TermItem term : itemsList) {
            if (term.title.contains(target))
                targetList.add(term);
            else {
                for (Sentence sentence : term.termList) {
                    if (sentence.text.contains(target)) {
                        targetList.add(term);
                        break;
                    }
                }
            }
        }
        TermItem[] termItems = new TermItem[targetList.size()];
        targetList.toArray(termItems);
        return termItems;
    }

    // 寻找目标字符串所包含的全部术语条目
    private TermItem[] MatchItem(String target) {
        List<TermItem> targetList = new ArrayList<>();
        for (TermItem term : itemsList) {
            if (target.contains(term.title))
                targetList.add(term);
            else {
                for (Sentence sentence : term.termList) {
                    if (target.contains(sentence.text)) {
                        targetList.add(term);
                        break;
                    }
                }
            }
        }
        TermItem[] termItems = new TermItem[targetList.size()];
        targetList.toArray(termItems);
        return termItems;
    }

    // 遍历当前术语库的全部条目，以字符串的形式，返回目标字符串所包含的所有术语条目
    public String Match(String target) {
        StringBuffer buffer = new StringBuffer();
        int i = 1;
        for (TermItem item : this.MatchItem(target)) {
            buffer.append("[").append(i).append("]").append(item.toString_2());
            i++;
        }
        return buffer.toString();
    }

    // 根据获取的文件条目生成对象
    public void SetUpLibrary(CAT_FileItem[] items) {
        for (CAT_FileItem item : items) {
            switch (item.label) {
                case "Name" -> this.name = item.GetContain(0);
                case "Save" -> this.save = item.GetContain(0);
                case "TermItem" -> {
                    TermItem termItem = new TermItem();
                    if (item.GetItem(0).equals("title"))
                        termItem.title = item.GetContain(0);
                    else
                        System.err.println("Expected <title>, wrong:" + item.GetItem(0));
                    for (int i = 1; i < item.GetLength(); i++) {
                        if (item.GetItem(i).equals("term"))
                            termItem.AddTerm(DealWithSentence(item.GetContain(i)));
                        else
                            System.err.println("Expected <term>, wrong:" + item.GetItem(i));
                    }
                    this.AddItem(termItem);
                }
                default -> System.err.println("Wrong item:" + item.label);
            }
        }
    }

    // 根据条目内容，拆分language和text生成一个Sentence
    private static Sentence DealWithSentence(String message) {
        Sentence sentence = new Sentence();
        String[] strings = BreakSentence(message); // 这里strings.length必定为2
        sentence.language = Language.GetLanguage(strings[0]);
        sentence.text = strings[1];
        return sentence;
    }

    // 将信息中的[语言]与内容分开
    private static String[] BreakSentence(String message) {
        String[] results = new String[2];
        char[] messages = message.toCharArray();
        int pointer = 0;
        while (messages[pointer] != ' ')
            pointer++;
        results[0] = message.substring(1, pointer - 1);
        results[1] = message.substring(pointer + 1);
        return results;
    }

    // 获得全部术语条目的title
    public String[] GetAllTitles() {
        String[] titles = new String[itemsList.size()];
        for (int i = 0; i < itemsList.size(); i++)
            titles[i] = itemsList.get(i).title;
        return titles;
    }

    // 获得按目标字符串筛选后所有条目的title
    public String[] GetAllTitles(String text) {
        TermItem[] termItems = SearchItem(text);
        String[] titles = new String[termItems.length];
        for (int i = 0; i < termItems.length; i++)
            titles[i] = termItems[i].title;
        return titles;
    }

    // 获得全部术语条目的术语
    public String[] GetAllTerms() {
        String[] contents = new String[itemsList.size()];
        for (int i = 0; i < itemsList.size(); i++)
            contents[i] = itemsList.get(i).GetTermsContent();
        return contents;
    }

    // 获得按目标字符串筛选后所有条目的术语
    public String[] GetAllTerms(String text) {
        TermItem[] termItems = SearchItem(text);
        String[] contents = new String[termItems.length];
        for (int i = 0; i < termItems.length; i++)
            contents[i] = termItems[i].GetTermsContent();
        return contents;
    }
}
