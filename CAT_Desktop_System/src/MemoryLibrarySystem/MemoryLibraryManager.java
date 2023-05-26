package MemoryLibrarySystem;

import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MemoryLibraryManager {
    public List<MemoryLibrary> memoryLibraryList=new ArrayList<>();

    // 实现单例模式
    public static MemoryLibraryManager instance=new MemoryLibraryManager();

    private MemoryLibraryManager(){

    }

    public static String MatchItem(MemoryLibrary memoryLibrary,String text){
        return memoryLibrary.Match(text);
    }

    public static MemoryLibrary CreateMemoryLibrary(String name,String save){
        return new MemoryLibrary(name,save);
    }

    public static void SaveLibrary(MemoryLibrary library){
        File file=new File(library.save);
        try (FileWriter out=new FileWriter(file)){
            out.write(library.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // 旧版本，暂时弃用
    public static MemoryLibrary Old_LoadLibrary(String save) {
        File file = new File(save);
        MemoryLibrary library = null;
        try {
            int charGet; // 读取的字符
            StringBuffer buffer=new StringBuffer();
            FileReader in=new FileReader(file);
            while ((charGet= in.read())!=-1){
                buffer.append((char) charGet);
            }
            library=new MemoryLibrary(save);
            library.SetUpLibrary(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance.memoryLibraryList.add(library);
        return library;
    }

    public static MemoryLibrary LoadLibrary(String save) {
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        MemoryLibrary library = new MemoryLibrary(null);
        library.SetUpLibrary(items);
        instance.memoryLibraryList.add(library);
        return library;
    }

    public static MemoryLibrary GetMemoryLibrary(int num){
        return instance.memoryLibraryList.get(num);
    }
}
