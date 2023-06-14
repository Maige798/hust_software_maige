/**
 * 类名：Test
 * 功能：测试类，存放各种类型的测试方法，手动测试各类
 */

package SystemUtil;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import MemoryLibrarySystem.*;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;
import TranslationSystem.EditHelper;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        TestAutoComplete();
    }

    public static void TestSpellCheck(){
        String text="Renenber," +
                " life mey not always be a bed of roses," +
                " but with the right mindset and determination," +
                " we can overbcome any obstacle that comes our way.";
        System.out.println(EditHelper.EnglishSpellCheck(text));
    }

    public static void TestAutoComplete() {
        String text = "Remember,li";
        System.out.println(EditHelper.AutoComplete(text, "life"));
    }

    public static void TestAssociate(){
        String text="Remember,li";
        System.out.println(EditHelper.EnglishAssociate(text));
    }

    public static void TestMemoryLibraryRead(){
        String myMemoryLibrary="D:\\hust_software_maige\\CAT_Desktop_System\\src\\MemoryLibrarySystem\\memlib.mlib";
        MemoryLibrary library= MemoryLibraryManager.LoadLibrary(myMemoryLibrary);
        System.out.println(library);
    }

    public static void TestMemoryLibrarySave(){
        TestMemoryLibraryRead();
        MemoryLibrary library= MemoryLibraryManager.GetMemoryLibrary(0);
        library.itemsList.get(0).origin.text="小牛马";
        TranslationItem newItem=new TranslationItem();
        newItem.origin=new Sentence(Language.Chinese,"夜店小王子");
        newItem.translation=new Sentence(Language.English,"NiKo");
        library.itemsList.add(newItem);
        System.out.println("Something has changed...\n"+library);
        MemoryLibraryManager.SaveLibrary(MemoryLibraryManager.GetMemoryLibrary(0));
    }

    public static void TestTermLibraryRead(){
        String myTermLibrary="D:\\hust_software_maige\\CAT_Desktop_System\\src\\TermLibrarySystem\\termlib.tlib";
        TermLibrary library= TermLibraryManager.LoadLibrary(myTermLibrary);
        System.out.println(library);
    }

    public static void TestTermLibrarySave() {
        TestTermLibraryRead();
        TermLibrary library = TermLibraryManager.GetTermLibrary("术语库");
        if (library != null) {
            library.GetItem("Maige").title = "Meinstein";
            library.GetItem("Meinstein").GetTerm(Language.GetLanguage("Russian")).text = "mAINESY";
            TermItem item = new TermItem("诸葛呼吸");
            item.AddTerm(new Sentence(Language.English, "HooXi"));
            item.AddTerm(new Sentence(Language.Chinese, "诸葛呼吸"));
            library.AddItem(item);
        }
        System.out.println("Something has changed...\n" + library);
        if (library != null)
            TermLibraryManager.SaveLibrary(library);
    }

    public static TranslationFile TestDivideParagraph(boolean print) {
        String fileName = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\FileSystem\\TestDivideParagraph.txt";
        TranslationFile translationFile = new TranslationFile("transFile", null, fileName, Language.Chinese, Language.English);
        TranslationFileManager.SetUpFile(translationFile);
        if (print)
            for (int i=0;i<translationFile.paragraphsList.size();i++)
                System.out.println("#"+i+translationFile.paragraphsList.get(i));
        return translationFile;
    }

    public static void TestMergeParagraph() {
        TranslationFile translationFile = TestDivideParagraph(true);
        translationFile.TranslateParagraph(0,"This file is used to test file division");
        translationFile.TranslateParagraph(2,"HUST examination rules");
        translationFile.TranslateParagraph(4,"--Copy From<<HUST Undergraduate Examination Management Work Rules>>");
        translationFile.TranslateParagraph(6,"No.19");
        translationFile.TranslateParagraph(9,"Students who are 30 minutes or more late for exam,");
        translationFile.TranslateParagraph(10,"are not allowed to take the exam.");
        translationFile.TranslateParagraph(11,"This course is punished as a lack of examination.");
        for (TranslationItem item : translationFile.paragraphsList)
            System.out.println(item);
        System.out.println(TranslationFileManager.MergeParagraphs(translationFile));
    }

    // 读取某个文件的内容
    public static String GetText(String save){
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader(save)) {
            int charGet;
            while ((charGet = reader.read()) != -1)
                builder.append((char) charGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
