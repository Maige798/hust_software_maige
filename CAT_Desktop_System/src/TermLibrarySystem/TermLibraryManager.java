package TermLibrarySystem;

import MemoryLibrarySystem.MemoryLibrary;
import SystemUtil.Sentence;
import SystemUtil.TermItem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TermLibraryManager {
    public List<TermLibrary> termLibraryList=new ArrayList<>();

    // 单例模式
    public static TermLibraryManager instance=new TermLibraryManager();

    private TermLibraryManager(){

    }

    public static TermItem[] MatchTerms(TermLibrary library, Sentence sentence){
        // todo
        return null;
    }

    // 创建一个TermLibrary
    public static TermLibrary CreateTermLibrary(String name,String save){
        TermLibrary termLibrary=new TermLibrary(name,save);
        instance.termLibraryList.add(termLibrary);
        return termLibrary;
    }

    // 导入术语库
    public static TermLibrary LoadLibrary(String save) {
        File file = new File(save);
        TermLibrary library = null;
        try {
            int charGet; // 读取的字符
            StringBuffer buffer = new StringBuffer();
            FileReader in = new FileReader(file);
            while ((charGet = in.read()) != -1) {
                buffer.append((char) charGet);
            }
            library = new TermLibrary(null, save);
            library.SetUpLibrary(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance.termLibraryList.add(library);
        return library;
    }

    // 保存术语库
    public static void SaveLibrary(TermLibrary library){
        try {
            File file=new File(library.save);
            FileWriter out=new FileWriter(file);
            out.write(library.toString());
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
