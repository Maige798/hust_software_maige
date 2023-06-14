/**
 * 类名：TranslationItem
 * 开发人员：阮泽同
 * 实现功能：基本类，生成记忆条目与翻译条目对象，封装两个Sentence
 */

package SystemUtil;

public class TranslationItem {
    public Sentence origin;
    public Sentence translation;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@TranItem {\r\n").append("\t<ori> ").append(origin).append("\r\n");
        if (this.translation != null)
            buffer.append("\t<tran> ").append(translation).append("\r\n");
        else
            buffer.append("\t<blank>\r\n");
        buffer.append("}\r\n");
        return buffer.toString();
    }

    // 构造方法
    public TranslationItem() {
        this.origin = new Sentence();
        this.translation = new Sentence();
    }

    public TranslationItem(Sentence origin, Sentence translation) {
        this.origin = origin;
        this.translation = translation;
    }

    public TranslationItem(Language originLanguage, String origin) {
        this.origin = new Sentence(originLanguage, origin);
        this.translation = null;
    }

    // 设置原文
    public void SetOrigin(Sentence Origin) {
        this.origin = Origin;
    }

    public void SetOrigin(Language language, String text) {
        this.origin = new Sentence(language, text);
    }

    // 设置译文内容
    public void SetTranslation(Sentence Translation) {
        this.translation = Translation;
    }

    public void SetTranslation(Language language, String text) {
        this.translation = new Sentence(language, text);
    }
}
