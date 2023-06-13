/**
 * 类名：UI_TermLibInputContent
 * 1.开发人员：阮泽同
 * 实现功能：与内核交互，导入术语库
 * 2.开发人员：刘闯
 * 实现功能：创建术语库导入界面的内容面板
 */

package UI_System.TermLibInput;

import ProjectSystem.ProjectManager;
import TermLibrarySystem.TermLibrary;
import TermLibrarySystem.TermLibraryManager;
import UI_System.TermLibraryCreateInterface;
import UI_System.TermLibraryInputInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UI_TermLibInputContent extends JPanel {
    public TermLibraryInputInterface inputInterface;

   public JLabel memoryLibraryImportLabel = new JLabel();

   public TextField createTextField = new TextField();

  public   JButton browseButton = new JButton();

   public JButton createButton = new JButton();

   public JButton importButton = new JButton();

    public List<String> filePaths = new ArrayList<>();


    public UI_TermLibInputContent(TermLibraryInputInterface inputInterface) {
        this.inputInterface=inputInterface;
        this.setLayout(null);

        memoryLibraryImportLabel.setText("术语库导入");
        this.add(memoryLibraryImportLabel);
        memoryLibraryImportLabel.setBounds(25, 20, 175, 50);

        this.add(createTextField);
        createTextField.setBounds(50, 130, 350, 30);

        browseButton.setText("浏览");
        this.add(browseButton);
        browseButton.setMargin(new Insets(0, 0, 0, 0));
        browseButton.setBounds(425, 130, 50, 30);
        browseButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(new UI_TermLibInputContent(inputInterface));
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePaths.add(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(filePaths.get(0));
                    UpdateSavePathButton();
                }
            }
        });


        createButton.setText("新建");
        this.add(createButton);
        createButton.setMargin(new Insets(0, 0, 0, 0));
        createButton.setBounds(130, 250, 100, 30);
        createButton.addActionListener(e -> OnCreateButtonDown());

        importButton.setText("导入");
        this.add(importButton);
        importButton.setMargin(new Insets(0, 0, 0, 0));
        importButton.setBounds(300, 250, 100, 30);
        importButton.addActionListener(e -> OnImportButtonDown());
    }

    private void OnImportButtonDown() {
        if (!createTextField.getText().equals("")) {
            TermLibrary library = TermLibraryManager.LoadLibrary(createTextField.getText());
            ProjectManager.instance.currentProject.AddTermLibrary(library);
            inputInterface.dispose();
        }
    }

    private void UpdateSavePathButton() {
        createTextField.setText(filePaths.get(filePaths.size() - 1));
    }

    private void OnCreateButtonDown() {
        new TermLibraryCreateInterface(inputInterface);
    }
}
