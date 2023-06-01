package UI_System.TermLibInput;

import javax.swing.*;
import java.awt.*;

public class UI_CreatePanel1 extends JPanel {
    JButton[] buttons;
public UI_CreatePanel1()
{
           this.setBackground(Color.BLUE);
    //网格袋布局
    GridLayout layout=new GridLayout(1,3);

    this.setLayout(layout);

    buttons=new JButton[]{new JButton("创建"),new JButton("删除"),new JButton("使用")};


        for(int i=0;i<3;i++)
    {
        this.add(buttons[i]);
    }
}


}
