/**
 * 类名：TermLibraryManager
 * 开发人员：阮泽同
 * 实现功能：术语库管理功能，包括术语库创建、导入、保存等功能
 */

package TermLibrarySystem;

import SystemUtil.CAT_FileController;
import SystemUtil.CAT_FileItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TermLibraryManager {
    public List<TermLibrary> termLibraryList=new ArrayList<>();

    // 单例模式
    public static TermLibraryManager instance=new TermLibraryManager();

    private TermLibraryManager() {

    }

    // 根据目标字符串匹配需要的术语条目
    public static String MatchTerms(TermLibrary library, String text) {
        return library.Match(text);
    }

    // 创建一个术语库，生成相应文件，返回其对象
    public static TermLibrary CreateTermLibrary(String name,String save) {
        TermLibrary termLibrary = new TermLibrary(name, save + name + ".tlib");
        File outFile = new File(save + name + ".tlib");
        instance.termLibraryList.add(termLibrary);
        try {
            if (!outFile.createNewFile()) {
                System.out.println("File already exist!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        SaveLibrary(termLibrary);
        return termLibrary;
    }

    public static TermLibrary LoadLibrary(String save) {
        CAT_FileItem[] items = CAT_FileController.ReadFile(save);
        TermLibrary library = new TermLibrary(null, null);
        library.SetUpLibrary(items);
        instance.termLibraryList.add(library);
        return library;
    }

    // 保存术语库
    public static void SaveLibrary(TermLibrary library){
        File file=new File(library.save);
        try (FileWriter out=new FileWriter(file)){
            out.write(library.toString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // 根据name获取TermLibrary
    public static TermLibrary GetTermLibrary(String name){
        for(TermLibrary library: instance.termLibraryList)
            if(library.name.equals(name))
                return library;
        return null;
    }

    public static TermLibrary GetTermLibrary(int num){
        return instance.termLibraryList.get(num);
    }
}
