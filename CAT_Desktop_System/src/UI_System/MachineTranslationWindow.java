package UI_System;

import javax.swing.*;

public class MachineTranslationWindow extends JFrame {
    public final String message1 = "好消息，本软件已成功和搜狗翻译达成合作";
    public final String message2 = "可复制下方网址，进入浏览器搜索，使用搜狗翻译在线服务！";
    public final String net = "https://fanyi.sogou.com/text";

    public JLabel label1;
    public JLabel label2;
    public JTextField textField;
    public JPanel panel;

    public MachineTranslationWindow() {
        setTitle("机器翻译界面");
        setSize(400, 240);
        setResizable(false);
        setLocationRelativeTo(null);
        SetUpPanel();
        setContentPane(panel);
        setVisible(true);
    }

    public void SetUpPanel() {
        label1 = new JLabel(message1);
        label2 = new JLabel(message2);
        textField = new JTextField(net);

        panel = new JPanel();
        panel.add(label1);
        panel.add(label2);
        panel.add(textField);

        textField.setEditable(false);
    }

    public static void main(String[] args) {
        new MachineTranslationWindow();
    }
}
