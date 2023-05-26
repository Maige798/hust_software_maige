package FileSystem;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TranslationFileManagerTest {

    @Test
    void loadFile() {
        String myFile = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\FileSystem\\MyTransFile.tran";
        String source = SystemUtil.Test.GetText(myFile);
        TranslationFile translationFile = TranslationFileManager.LoadFile(myFile);
        assertEquals(source, translationFile.toString());
    }
}
