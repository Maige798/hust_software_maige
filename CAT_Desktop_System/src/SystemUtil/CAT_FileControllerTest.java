/**
 * 类名：CAT_FileControllerTest
 * 测试：系统文件的读取
 */

package SystemUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CAT_FileControllerTest {

    @Test
    void readFile() {
        String fileSave = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\SystemUtil\\MyFileItem.fitem";
        String result=SystemUtil.Test.GetText(fileSave);
        StringBuffer buffer=new StringBuffer();
        CAT_FileItem[] items=CAT_FileController.ReadFile(fileSave);
        for(CAT_FileItem item:items)
            buffer.append(item).append("\r\n");
        assertEquals(result, buffer.toString());
    }
}
