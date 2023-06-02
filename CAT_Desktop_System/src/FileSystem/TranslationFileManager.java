package FileSystem;

import SystemUtil.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TranslationFileManager {
    public static final String savePath = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\System_File\\TranslationFilePackage\\";
    // 实现单例模式
    public static TranslationFileManager instance = new TranslationFileManager();

    private TranslationFileManager() {

    }

    // 读取目标文件后创建相应的翻译文件对象
    public static TranslationFile ReadFile(String name, String sourceFile, Language origin, Language target) {
        TranslationFile translationFile = new TranslationFile(name, savePath + name + ".tran", sourceFile, origin, target);
        SetUpFile(translationFile);
        return translationFile;
    }

    // 保存翻译文件
    public static void SaveFile(TranslationFile translationFile) {
        File file = new File(translationFile.save);
        try (FileWriter out = new FileWriter(file)) {
            out.write(translationFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 导出并生成一个合并翻译后所有段落的文件
    public static int DeriveFile(TranslationFile translationFile, String targetSave, String targetSaveName) {
        File outFile = new File(targetSave + targetSaveName + ".txt");
        try {
            if (!outFile.createNewFile()) {
                System.out.println("File already exist!");
                return -1;
            } else {
                FileWriter out = new FileWriter(outFile);
                out.write(MergeParagraphs(translationFile));
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void SetUpFile(TranslationFile translationFile) {
        if (translationFile != null) {
            try (FileReader in = new FileReader(translationFile.sourceFile)) {
                int charGet; // 读取的字符
                StringBuffer buffer = new StringBuffer();
                while ((charGet = in.read()) != -1)
                    buffer.append((char) charGet);
                translationFile.SetUpParagraphs(buffer.toString());
                SaveFile(translationFile);
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
        TranslationFile translationFile = new TranslationFile();
        translationFile.SetUpTranslationFile(items);
        return translationFile;
    }

    private static void SetUpParagraph(TranslationFile translationFile) {
        // maybe this method is useless
    }

    // 文档分段，这个方法貌似没用，暂时丢弃
    private static Sentence[] DivideParagraphs(String content) {
        // maybe this method is useless
        return null;
    }

    // 文档合并
    public static String MergeParagraphs(TranslationFile translationFile) {
        return translationFile.GetMergedParagraphs();
    }
}
