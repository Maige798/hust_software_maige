package UI_System.CreateProject;


import javax.swing.*;

public class UI_ContentPanel extends JPanel {

    public UI_FileListPanel panel2 = new UI_FileListPanel();

    public UI_ContentPanel() {
        this.setLayout(null);

        this.add(panel2);

        panel2.setBounds(0, 0, 750, 500);
    }
}
