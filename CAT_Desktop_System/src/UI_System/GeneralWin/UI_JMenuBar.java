package UI_System.GeneralWin;

import javax.swing.*;

public class UI_JMenuBar extends JMenuBar {
    public JMenu menu1;
    public JMenu menu2;
    public JMenu menu3;
    public JMenu menu4;
    public JMenu menu5;
    public JMenu menu6;

    public JMenuItem item1;
    public JMenuItem item2;
    public JMenuItem item3;

    public UI_JMenuBar() {
        menu1 = new JMenu("文件");
        menu2 = new JMenu("菜单");
        menu3 = new JMenu("项目");
        menu4 = new JMenu("选项四");
        menu5 = new JMenu("选项五");
        menu6 = new JMenu("选项六");

        item1 = new JMenuItem("译文另存为");
        item2 = new JMenuItem("保存");
        item3 = new JMenuItem("关闭");

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);

        add(menu1);
        add(menu2);
        add(menu3);
        add(menu4);
        add(menu5);
        add(menu6);
    }
}
