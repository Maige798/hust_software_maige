package javaswing;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public static void main(String[] args){
        //创建中间容器
        JPanel panel = new JPanel();
        //创建基本组件
        JButton btn =  new JButton();
        panel.add(btn);
        //显示窗口
        //创建一个窗口
        JFrame jf = new JFrame("主界面");
        //把面板容器作为窗口内容面板，设置到窗口
        jf.setContentPane(panel);
        //设置窗口大小
        jf.setSize(800,600);
        //把窗口位置设置到屏幕中心
        jf.setLocationRelativeTo(null);
        //当点击关闭按钮退出程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //使窗口可视化
        jf.setVisible(true);
    }
}
