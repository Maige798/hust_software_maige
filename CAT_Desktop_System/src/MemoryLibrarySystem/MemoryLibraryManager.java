package MemoryLibrarySystem;

import SystemUtil.Sentence;

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

    public static String MatchItem(Sentence sentence){
        // todo
        return null;
    }

    public static MemoryLibrary CreateMemoryLibrary(String name){
        // todo
        return null;
    }

    public static void SaveLibrary(MemoryLibrary library){
        try {
            File file=new File(library.save);
            FileWriter out=new FileWriter(file);
            out.write(library.toString());
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static MemoryLibrary LoadLibrary(String save) {
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

    public static MemoryLibrary GetMemoryLibrary(int num){
        return instance.memoryLibraryList.get(num);
    }
}
