package SystemUtil;

import MemoryLibrarySystem.*;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;

public class Test {
    public static void main(String[] args) {
        TestTermLibraryRead();
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
}
