package UI_System.TermLibInput;

import javax.swing.*;

public class UI_ContentPanel extends JPanel {
    //创建导航栏(三个按钮）
    JPanel panel1 = new UI_CreatePanel1();

    //创建上面的表格
    JPanel panel2 = new UI_CreatePanel2();

    //设置中间两个按钮
    JPanel panel3 = new UI_CreatePanel3();

    //创建下面的表格
    JPanel panel4 = new UI_CreatePanel4();

    //创建最下面的两个按钮
    JPanel panel5 = new UI_CreatePanel3();

    public UI_ContentPanel() {
        this.setLayout(null);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);

        panel1.setBounds(100, 50, 600, 50);

        panel2.setBounds(100, 100, 600, 75);

        panel3.setBounds(100, 175, 600, 50);

        panel4.setBounds(100, 225, 600, 100);

        panel5.setBounds(100, 325, 600, 50);
    }
}
