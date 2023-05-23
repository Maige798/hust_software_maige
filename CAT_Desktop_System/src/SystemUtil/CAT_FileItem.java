package SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class CAT_FileItem {
    public String label;
    public List<String> items = new ArrayList<>();
    public List<String> contains = new ArrayList<>();

    // 构造方法
    public CAT_FileItem(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("@").append(label);
        if (items.size() != 0 && contains.size() != 0) {
            buffer.append(" {\r\n");
            for (int i = 0; i < items.size(); i++)
                buffer.append("\t<").append(items.get(i)).append("> ").append(contains.get(i)).append("\r\n");
            buffer.append("}\r\n");
        }
        else
            buffer.append("\r\n");
        return buffer.toString();
    }

    public void AddItem(String item) {
        this.items.add(item);
    }

    public void AddContain(String contain) {
        this.contains.add(contain);
    }

    public String GetItem(int num) {
        return this.items.get(num);
    }

    public String GetContain(int num) {
        return this.contains.get(num);
    }

    public int GetLength(){
        if(this.items.size()!=this.contains.size())
            System.err.println("wrong: items:"+items.size()+"\tcontains:"+contains.size());
        return items.size();
    }
}
