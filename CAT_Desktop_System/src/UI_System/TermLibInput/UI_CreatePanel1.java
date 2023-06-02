package UI_System.TermLibInput;

import javax.swing.*;
import java.awt.*;

public class UI_CreatePanel1 extends JPanel {
    public JButton CreateButton=new JButton("创建");
    public JButton DeleteButton=new JButton("删除");
    public JButton UseButton=new JButton("使用");

    public UI_CreatePanel1() {
        this.setBackground(Color.BLUE);
        //网格袋布局
        GridLayout layout = new GridLayout(1, 3);

        this.setLayout(layout);
        this.add(CreateButton);
        this.add(DeleteButton);
        this.add(UseButton);
    }
}
