package TermLibrarySystem;

import SystemUtil.*;

import java.util.ArrayList;
import java.util.List;

public class TermLibrary {
    public String name; // 术语库的名称
    public String save; // 术语库的存储路径
    public List<TermItem> itemsList;

    // 构造方法
    public TermLibrary(String Name,String Save){
        this.name=Name;
        this.save=Save;
        this.itemsList=new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuffer buffer=new StringBuffer();
        buffer.append("@Name {\r\n\t<name> ").append(this.name).append("\r\n}\r\n\r\n");
        buffer.append("@Save {\r\n\t<save> ").append(this.save).append("\r\n}\r\n\r\n");
        for(TermItem item:this.itemsList)
            buffer.append(item).append("\r\n");
        return buffer.toString();
    }

    // 添加一条术语条目
    public void AddItem(TermItem termItem){
        itemsList.add(termItem);
    }

    // 删除一条术语条目
    public void RemoveItem(TermItem termItem) {
        itemsList.removeIf(term -> term.equals(termItem));
    }

    public void EditItem(TermItem termItem) {
        // todo
    }

    // 返回第一个符合title的TermItem
    public TermItem GetItem(String title){
        for(TermItem item:this.itemsList)
            if(item.title.equals(title))
                return item;
        return null;
    }

    // 寻找title包含目标字符串的全部术语条目
    public TermItem[] SearchItem(String target){
        List<TermItem> targetList=new ArrayList<>();
        for(TermItem term:itemsList)
            if(term.title.contains(target))
                targetList.add(term);
        TermItem[] termItems=new TermItem[targetList.size()];
        targetList.toArray(termItems);
        return termItems;
    }

    // 根据获取的信息生成对象（旧方法，暂时弃用）
    public void SetUpLibrary(String message){
        char[] messages=message.toCharArray();
        int pointer=0;
        StringBuffer buffer=new StringBuffer();
        while (pointer<messages.length){
            if(messages[pointer]=='@'){
                pointer++; // 指向@下一个字符
                while (Character.isLetter(messages[pointer])) {
                    buffer.append(messages[pointer]);
                    pointer++;
                }
                if(buffer.toString().equals("Name")){ // 匹配到@Name
                    buffer.delete(0, buffer.length());
                    while (messages[pointer] != '{')
                        pointer++; // 省略{
                    pointer++;
                    while (messages[pointer] != '}') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    this.name = buffer.toString();
                    buffer.delete(0,buffer.length());
                }
                else if(buffer.toString().equals("Save")){ // 匹配到@save
                    buffer.delete(0, buffer.length());
                    while (messages[pointer] != '{')
                        pointer++;
                    pointer++;
                    while (messages[pointer] != '}') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    this.save = buffer.toString();
                    buffer.delete(0,buffer.length());
                } else if (buffer.toString().equals("TermItem")) {
                    TermItem item = new TermItem();
                    buffer.delete(0, buffer.length());
                    while (messages[pointer] != '<')
                        pointer++; // 省去{至<中的字符
                    pointer++; // 指向<下一个字符
                    while (messages[pointer] != '>') {
                        buffer.append(messages[pointer]);
                        pointer++;
                    }
                    pointer++;
                    if (buffer.toString().equals("Title")) { // 匹配到<title>
                        buffer.delete(0, buffer.length());
                        pointer++; // 跳过>至内容间的空格
                        while (messages[pointer] != '\r') {
                            buffer.append(messages[pointer]);
                            pointer++;
                        }
                        item.title = buffer.toString();
                    } else {
                        System.err.println("Wrong item:" + buffer);
                    }
                    buffer.delete(0, buffer.length());
                    while (messages[pointer]!='}') { // 没有读到}则说明该术语库仍然有term条目
                        while (messages[pointer] != '<'&&messages[pointer]!='}')
                            pointer++;
                        if(messages[pointer]=='<'){
                            pointer++;
                            while (messages[pointer] != '>') {
                                buffer.append(messages[pointer]);
                                pointer++;
                            }
                            if (buffer.toString().equals("term")) { // 匹配到<term>
                                Sentence term = new Sentence();
                                buffer.delete(0, buffer.length());
                                while (messages[pointer] != '[')
                                    pointer++; // 省去>至[之间的字符]
                                pointer++;
                                while (messages[pointer] != ']') {
                                    buffer.append(messages[pointer]);
                                    pointer++;
                                }
                                pointer++;
                                term.language = Language.GetLanguage(buffer.toString());
                                buffer.delete(0, buffer.length());
                                if (messages[pointer] == ' ')
                                    pointer++;
                                while (messages[pointer] != '\r') {
                                    buffer.append(messages[pointer]);
                                    pointer++;
                                }
                                term.text = buffer.toString();
                                item.AddTerm(term);
                            } else {
                                System.err.println("Wrong item: "+buffer);
                            }
                            buffer.delete(0,buffer.length());
                        }
                    }
                    this.itemsList.add(item);
                }
            }
            pointer++;
        }
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
}
