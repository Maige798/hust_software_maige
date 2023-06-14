/**
 * 类名：TranslationFileManagerTest
 * 测试：翻译文件的导入功能
 */

package FileSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TranslationFileManagerTest {

    @Test
    void loadFile() {
        String myFile = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\FileSystem\\MyTransFile.tran";
        String source = SystemUtil.Test.GetText(myFile);
        TranslationFile translationFile = TranslationFileManager.LoadFile(myFile);
        assertEquals(source, translationFile.toString());
    }
}
