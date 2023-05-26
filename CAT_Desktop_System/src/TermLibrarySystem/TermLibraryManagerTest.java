package TermLibrarySystem;

import SystemUtil.TermItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermLibraryManagerTest {

    @Test
    void loadLibrary() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\TermLibrarySystem\\termlib.tlib";
        String source= SystemUtil.Test.GetText(myFile);
        TermLibrary library=TermLibraryManager.LoadLibrary(myFile);
        assertEquals(source,library.toString());
    }

    @Test
    void matchTerms() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\TermLibrarySystem\\termlib.tlib";
        String text="李培楠大战虫族领袖，诸葛呼吸在一旁观战";
        TermLibrary library=TermLibraryManager.LoadLibrary(myFile);
        TermItem[] matchedItems=TermLibraryManager.MatchTerms(library,text);
        TermItem[] targetItems={library.GetItem(2),library.GetItem(3),library.GetItem(4)};
        for(TermItem item:matchedItems)
            System.out.println(item);
        assertArrayEquals(targetItems,matchedItems);
    }
}
