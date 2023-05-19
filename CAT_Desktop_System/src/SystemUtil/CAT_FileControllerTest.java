package SystemUtil;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CAT_FileControllerTest {

    @Test
    void readFile() {
        String fileSave = "D:\\hust_software_maige\\CAT_Desktop_System\\src\\SystemUtil\\MyFileItem.fitem";
        String result = """
                       @Name {\r
                       \t<name> 名字\r
                       }\r
                       \r
                       @Save {\r
                       \t<save> 路径
                       }\r
                       \r
                       @Item {
                       \t<abc> ABC
                       \t<def> DEF
                       \t<maige> 麦哥
                       }\r
                       \r
                       @TransItem {\r
                       \t<ori> [Chinese] 麦哥\r
                       \t<tran> [English] Maige\r
                       }\r
                       \r
                       @Blank\r
                       \r
                       @Return\r
                       \r
                       @Table\r
                       \r
                       @AAA {\r
                       \t<aaa> AAA\r
                       }\r
                       \r
                       """;
        StringBuffer buffer=new StringBuffer();
        CAT_FileItem[] items=CAT_FileController.ReadFile(fileSave);
        for(CAT_FileItem item:items)
            buffer.append(item).append("\r\n");
        assertEquals(result, buffer.toString());
    }
}