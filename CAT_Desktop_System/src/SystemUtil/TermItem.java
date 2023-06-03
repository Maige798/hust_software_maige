package SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class TermItem {
    public String title;
    public List<Sentence> termList;

    // 构造方法
    public TermItem() {
        this.termList = new ArrayList<>();
    }

    public TermItem(String Title) {
        this.title = Title;
        this.termList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("@TermItem {\r\n" + "\t<title> " + this.title + "\r\n");
        for (Sentence listItem : termList)
            content.append("\t<term> ").append(listItem.toString()).append("\r\n");
        content.append("}\r\n");
        return content.toString();
    }

    // 用于术语匹配时返回的字符串
    public String toString_2() {
        StringBuilder content = new StringBuilder(this.title + "\r\n");
        for (Sentence listItem : termList)
            content.append(listItem.toString()).append("\r\n");
        return content.toString();
    }

    // 当一个新条目使用语言未出现在termList中时，在termList中添加此新条目
    public void AddTerm(Sentence sentence) {
        for (Sentence listItem : termList) {
            if (listItem.language.EqualsTo(sentence.language)) {
                System.err.println("Language:" + sentence.language.toString() + " already exists in TermItem:" + this.title);
                return;
            }
        }
        termList.add(sentence);
    }

    // 根据语言类型移除特定的条目
    public void RemoveTerm(Language language) {
        termList.removeIf(listItem -> listItem.language.EqualsTo(language));
    }

    // 获取目标语言类型的对应条目
    public Sentence GetTerm(Language language) {
        for (Sentence listItem : termList) {
            if (listItem.language.EqualsTo(language))
                return listItem;
        }
        System.err.println("Language:" + language + " doesn't exist in TermItem:" + this.title);
        return null;
    }

    // 将另外一个TermItem的内容以高优先级合并入此TermItem
    public void Merge(TermItem other) {
        for (Sentence otherTerms : other.termList) {
            boolean hasSameLanguage = false;
            for (Sentence terms : this.termList) {
                if (terms.language.EqualsTo(otherTerms.language)) {
                    terms.text = otherTerms.text;
                    hasSameLanguage = true;
                    break;
                }
            }
            if (!hasSameLanguage)
                AddTerm(otherTerms);
        }
    }
}
