package FileSystem;

import SystemUtil.Sentence;
import SystemUtil.TranslationItem;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TranslationFileManager {
    // 实现单例模式
    public TranslationFileManager instance = new TranslationFileManager();

    private TranslationFileManager() {

    }

    public static TranslationFile ReadFile() {
        // todo
        return null;
    }

    public static void SaveFile(TranslationFile translationFile) {
        // todo
    }

    public static void DeriveFile(TranslationFile translationFile,String targetSave) {
        // todo: to derive a file that contains the return value of TranslationFileManager.MergeParagraphs(translationFile) at targetSave
    }

    public static void SetUpFile(TranslationFile translationFile) {
        if (translationFile != null) {
            try {
                FileReader in = new FileReader(translationFile.sourceFile);
                int charGet; // 读取的字符
                StringBuffer buffer = new StringBuffer();
                while ((charGet = in.read()) != -1)
                    buffer.append((char) charGet);
                translationFile.SetUpParagraphs(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("TranslationFile is null");
        }
    }

    public static void SetUpParagraph(TranslationFile translationFile) {
        // maybe this method is useless
    }

    // 文档分段
    public static Sentence[] DivideParagraphs(String content) {
        // maybe this method is useless
        return null;
    }

    // 文档合并
    public static String MergeParagraphs(TranslationFile translationFile) {
        return translationFile.GetMergedParagraphs();
    }
}
