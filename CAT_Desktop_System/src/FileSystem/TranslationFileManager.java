package FileSystem;

import SystemUtil.Sentence;

public class TranslationFileManager {
    // 实现单例模式
    public TranslationFileManager instance = new TranslationFileManager();

    private TranslationFileManager() {

    }

    public static TranslationFile ReadFile(){
        // todo
        return null;
    }

    public static void SaveFile(){
        // todo
    }

    public static void DeriveFile(){
        // todo
    }

    public static void SetUpFile(){
        // todo
    }

    public static void SetUpParagraph(){
        // todo
    }

    public static Sentence[] DivideParagraphs(String content){
        // todo
        return null;
    }

    public static String MergeParagraphs(TranslationFile translationFile){
        // todo
        return null;
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
