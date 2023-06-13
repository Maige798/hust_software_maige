/**
 * 类名：Sentence
 * 开发人员：阮泽同
 * 实现功能：基本类，封装Language与String
 */

package SystemUtil;

public class Sentence implements Comparable {
    public Language language; // 该语句的语言
    public String text; // 该语句的内容

    @Override
    public String toString() {
        return "[" + this.language + "] " + this.text;
    }

    @Override
    public int compareTo(Object o) {
        Sentence other = (Sentence) o;
        return Integer.compare(this.language.ordinal(), other.language.ordinal());
    }

    // 构造方法
    public Sentence() {
        this.language = null;
        this.text = null;
    }

    public Sentence(Language language, String text) {
        this.text = text;
        this.language = language;
    }
}