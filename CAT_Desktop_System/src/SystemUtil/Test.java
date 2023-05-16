package SystemUtil;

import FileSystem.TranslationFile;
import FileSystem.TranslationFileManager;
import MemoryLibrarySystem.*;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;

public class Test {
    public static void main(String[] args) {
        TestDivideParagraph();
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

    public static void TestDivideParagraph() {
        String fileName = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\FileSystem\\TestDivideParagraph.txt";
        TranslationFile translationFile = new TranslationFile("transFile", null, fileName, Language.Chinese, Language.English);
        TranslationFileManager.SetUpFile(translationFile);
        for(TranslationItem item:translationFile.paragraphsList)
            System.out.println(item);
    }
}
