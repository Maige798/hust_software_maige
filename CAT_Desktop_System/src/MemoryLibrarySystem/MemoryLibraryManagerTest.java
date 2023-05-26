package MemoryLibrarySystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryLibraryManagerTest {

    @Test
    void loadLibrary() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\MemoryLibrarySystem\\memlib.mlib";
        String source= SystemUtil.Test.GetText(myFile);
        MemoryLibrary library=MemoryLibraryManager.LoadLibrary(myFile);
        System.out.println(library);
        assertEquals(source,library.toString());
    }

    @Test
    void matchItem() {
        String myFile = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\MemoryLibrarySystem\\memlib.mlib";
        String text = "虫族领";
        MemoryLibrary library = MemoryLibraryManager.LoadLibrary(myFile);
        String matchedText = MemoryLibraryManager.MatchItem(library, text);
        System.out.println(matchedText);
    }
}
