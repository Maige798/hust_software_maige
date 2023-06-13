/**
 * 类名：MemoryLibraryManager
 * 开发人员：阮泽同
 * 实现功能：记忆库管理功能，包括记忆库创建、导入、保存等功能
 */

package MemoryLibrarySystem;

import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;
import SystemUtil.Language;

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

    // 新建一个记忆库文件，并返回该文件的对象
    public static MemoryLibrary CreateMemoryLibrary(String name, String save, Language origin,Language translation) {
        MemoryLibrary library = new MemoryLibrary(name, save + name + ".mlib", origin, translation);
        File outFile = new File(save + name + ".mlib");
        try {
            if (!outFile.createNewFile()) {
                System.out.println("File already exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        instance.memoryLibraryList.add(library);
        SaveLibrary(library);
        return library;
    }

    public static void SaveLibrary(MemoryLibrary library){
        File file=new File(library.save);
        try (FileWriter out=new FileWriter(file)){
            out.write(library.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
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
