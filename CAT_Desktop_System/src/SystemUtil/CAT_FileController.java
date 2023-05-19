package SystemUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CAT_FileController {
    public static CAT_FileItem[] ReadFile(String save) {
        File file = new File(save);
        CAT_FileItem[] fileItems = null;
        try {
            FileReader in = new FileReader(file);
            int charGet;
            StringBuffer buffer = new StringBuffer();
            while ((charGet = in.read()) != -1)
                buffer.append((char) charGet);
            fileItems = DivideItems(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileItems;
    }

    public static CAT_FileItem[] DivideItems(String message){
        char[] messages=message.toCharArray();
        List<CAT_FileItem> _items=new ArrayList<>();
        int pointer=0;
        StringBuffer buffer=new StringBuffer();
        while (pointer<messages.length){
            if(messages[pointer]=='@'){
                pointer++; // 跳过@
                CAT_FileItem cat_fileItem=new CAT_FileItem(null);
                while (Character.isLetter(messages[pointer])){
                    buffer.append(messages[pointer]);
                    pointer++;
                }
                cat_fileItem.label=buffer.toString();
                buffer.delete(0,buffer.length());
                if(messages[pointer]!='\r'&&messages[pointer]!='\n') {
                    while (messages[pointer] != '}') { // 没有读到}则说明仍然有条目
                        while (messages[pointer] != '<' && messages[pointer] != '}')
                            pointer++;
                        if (messages[pointer] == '<') {
                            pointer++; //
                            while (messages[pointer] != '>') {
                                buffer.append(messages[pointer]);
                                pointer++;
                            }
                            pointer++; // 跳过>
                            cat_fileItem.AddItem(buffer.toString());
                            buffer.delete(0, buffer.length());
                            pointer++; // 跳过空格
                            while (messages[pointer] != '\r' && messages[pointer] != '\n') {
                                buffer.append(messages[pointer]);
                                pointer++;
                            }
                            cat_fileItem.AddContain(buffer.toString());
                            buffer.delete(0, buffer.length());
                        }
                    }
                }
                _items.add(cat_fileItem);
            }
            pointer++;
        }
        CAT_FileItem[] fileItems=new CAT_FileItem[_items.size()];
        _items.toArray(fileItems);
        return fileItems;
    }
}
