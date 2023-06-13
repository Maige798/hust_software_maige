/**
 * 类名：TermLibraryInputInterface
 * 开发人员：刘闯
 * 实现功能：创建术语库导入界面
 */

package UI_System;

import UI_System.TermLibInput.UI_TermLibInputContent;

import javax.swing.*;
import java.awt.*;

public class TermLibraryInputInterface extends JFrame {
    public TermLibraryInputInterface() {
        init();
    }

    public void init() {
        //窗口设置
        setSize(500, 350);
        setTitle("术语库导入");

        setBackground(Color.decode("#EAECF2"));
        setResizable(false);    //窗口设置

        JPanel panel = new UI_TermLibInputContent();

        setContentPane(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TermLibraryInputInterface me = new TermLibraryInputInterface();
    }
}
