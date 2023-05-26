package FileSystem;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TranslationFileManagerTest {

    @Test
    void loadFile() {
        String myFile = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\FileSystem\\MyTransFile.tran";
        String source = null;
        try (FileReader reader = new FileReader(myFile)) {
            int charGet;
            StringBuilder builder = new StringBuilder();
            while ((charGet = reader.read()) != -1)
                builder.append((char) charGet);
            source = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TranslationFile translationFile = TranslationFileManager.LoadFile(myFile);
        assertEquals(source, translationFile.toString());
    }
}