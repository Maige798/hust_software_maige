package TermLibrarySystem;

import SystemUtil.TermItem;

import java.util.ArrayList;
import java.util.List;

public class TermLibrary {
    public String name; // 术语库的名称
    public String save; // 术语库的存储路径
    public List<TermItem> itemsList=new ArrayList<>();

    // 构造方法
    public TermLibrary(String Name,String Save){
        this.name=Name;
        this.save=Save;
    }

    @Override
    public String toString(){
        // todo
        return null;
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

    // 根据获取的信息生成对象
    public void SetUpLibrary(String message){
        // todo
    }
}
