package TermLibrarySystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermLibraryManagerTest {

    @Test
    void loadLibrary() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\TermLibrarySystem\\termlib.tlib";
        TermLibrary library=TermLibraryManager.LoadLibrary(myFile);
        System.out.println(library);
    }
}
