package FileSystem;

import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;
import SystemUtil.Sentence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TranslationFileManager {
    // 实现单例模式
    public static TranslationFileManager instance = new TranslationFileManager();

    private TranslationFileManager() {

    }

    public static TranslationFile ReadFile() {
        // todo
        return null;
    }

    // 保存翻译文件
    public static void SaveFile(TranslationFile translationFile) {
        File file=new File(translationFile.save);
        try(FileWriter out=new FileWriter(file)){
            out.write(translationFile.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void DeriveFile(TranslationFile translationFile,String targetSave) {
        // todo: to derive a file that contains the return value of TranslationFileManager.MergeParagraphs(translationFile) at targetSave
    }

    public static void SetUpFile(TranslationFile translationFile) {
        if (translationFile != null) {
            try (FileReader in = new FileReader(translationFile.sourceFile)) {
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

    // 根据路径读取翻译文件内容
    public static TranslationFile LoadFile(String save) {
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        TranslationFile translationFile=new TranslationFile();
        translationFile.SetUpTranslationFile(items);
        return translationFile;
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
