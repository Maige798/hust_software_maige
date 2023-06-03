package UI_System.TermLibInput;

import javax.swing.*;

public class UI_CreatePanel3 extends JPanel {
    JButton[] buttons;

    public UI_CreatePanel3() {

        buttons = new JButton[]{new JButton("上一页"), new JButton("下一页")};

        for (int i = 0; i < 2; i++) {
            this.add(buttons[i]);
        }
    }
}
