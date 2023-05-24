package MemoryLibrarySystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryLibraryManagerTest {

    @Test
    void loadLibrary() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\MemoryLibrarySystem\\memlib.mlib";
        MemoryLibrary library=MemoryLibraryManager.LoadLibrary(myFile);
        System.out.println(library);
    }
}
