/**
 * 类名：TermLibraryManagerTest
 * 测试：术语库导入
 */

package TermLibrarySystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermLibraryManagerTest {

    @Test
    void loadLibrary() {
        String myFile="D:\\hust_software_maige\\CAT_Desktop_System\\src\\TermLibrarySystem\\termlib.tlib";
        String source= SystemUtil.Test.GetText(myFile);
        TermLibrary library=TermLibraryManager.LoadLibrary(myFile);
        assertEquals(source,library.toString());
    }
}
