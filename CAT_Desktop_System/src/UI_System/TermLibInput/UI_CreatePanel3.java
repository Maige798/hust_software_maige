package UI_System.TermLibInput;

import javax.swing.*;

public class UI_CreatePanel3 extends JPanel {
    JButton[] buttons;
    public UI_CreatePanel3()
    {

        //panel3.setBackground(Color.BLUE);
        // panel3.setLayout(null);

buttons=new JButton[]{new JButton("上一页"),new JButton("下一页")};

//        buttons[0].setBounds(300,195,50,25);
//        buttons[1].setBounds(450,195,50,25);

        for(int i=0;i<2;i++)
        {
            this.add(buttons[i]);
        }
    }
}
