package UI_System.EditWin;

import FileSystem.TranslationFileManager;
import MemoryLibrarySystem.MemoryLibraryManager;
import ProjectSystem.ProjectManager;
import SystemUtil.Language;
import SystemUtil.TranslationItem;
import TranslationSystem.EditHelper;
import UI_System.AssociationWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

public class UI_EditPanel extends JPanel {
    public UI_MemoryLibraryPanel memoryLibraryPanel;
    public UI_TermLibraryPanel termLibraryPanel;
    public UI_EditorSpellCheckPanel spellCheckPanel;

    public Color BlueColor = new Color(128, 255, 255);

    public static final int itemFieldNum = 8;

    public JLabel editLabels0;
    public JLabel editLabels1;
    public JLabel editLabels2;

    public int currentPageNum = 0;
    public JLabel bookPrint;
    public JLabel[] states;
    public JTextField[] texts;        //数组长度16，偶数左，奇数右
    int focusNum = -1; // 初始化为-1
    TranslationItem[] translationItems;

    public JButton confirmTranslationButton;
    public JButton startMachineTranslation;
    public JButton formerPageButton;
    public JButton nextPageButton;
    public JButton associateButton;

    public UI_EditPanel() {

        setLayout(null);
        setBackground(BlueColor);

        editLabels0 = new JLabel("原文");
        editLabels0.setForeground(Color.BLACK);
        editLabels1 = new JLabel("状态");
        editLabels1.setForeground(Color.BLACK);
        editLabels2 = new JLabel("译文");
        editLabels2.setForeground(Color.BLACK);

        bookPrint = new JLabel("?/?");
        bookPrint.setForeground(Color.BLACK);

        states = new JLabel[8];
        for (int i = 0; i < states.length; i++) {
            states[i] = new JLabel("0");
            states[i].setFont(new Font("宋体", Font.BOLD, 15));
            states[i].setForeground(Color.BLACK);
        }
        if (ProjectManager.instance.currentProject != null && ProjectManager.instance.currentTranslationFile != null)
            translationItems = ProjectManager.instance.currentTranslationFile.GetPureTranslationItem();

        texts = new JTextField[2 * itemFieldNum];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = new JTextField(8);
            int num = i;
            texts[i].addFocusListener(new FocusListener() {
                public final int itemNumber = num / 2;

                @Override
                public void focusGained(FocusEvent e) {
                    focusNum = itemNumber;
                    UpdateMemoryLibraryMessage();
                    UpdateTermLibraryMessage();
                    if (!texts[itemNumber * 2 + 1].getText().equals(""))
                        SpellCheck(texts[itemNumber * 2 + 1].getText());
                }

                @Override
                public void focusLost(FocusEvent e) {
                    spellCheckPanel.SetText("");
                }
            });
        }

        associateButton = new JButton("自动完成 (输入联想)");
        confirmTranslationButton = new JButton("确认翻译");
        startMachineTranslation = new JButton("机器翻译");

        formerPageButton = new JButton("上一页");
        nextPageButton = new JButton("下一页");

        add(editLabels0);
        add(editLabels1);
        add(editLabels2);
        add(bookPrint);

        for (JLabel jLabel : states) {
            add(jLabel);
        }

        for (JTextField textField : texts) {
            add(textField);
        }

        add(associateButton);
        add(confirmTranslationButton);
        add(startMachineTranslation);
        add(formerPageButton);
        add(nextPageButton);

        editLabels0.setBounds(45, 10, 300, 30);
        editLabels1.setBounds(380, 10, 30, 30);
        editLabels2.setBounds(435, 10, 30, 30);
        bookPrint.setBounds(620, 380, 40, 20);

        int yBegin = 55;
        for (int i = 0; i < states.length; i++) {
            states[i].setBounds(385, yBegin + i * 40, 20, 30);
        }

        int yFirst = 55;
        int ySecond = 55;
        for (int i = 0; i < texts.length; i += 2) {
            texts[i].setBounds(45, yFirst + i * 20, 320, 30);
            texts[i].setEditable(false);
        }
        for (int i = 1; i < texts.length; i += 2) {
            texts[i].setBounds(415, yFirst + (i - 1) * 20, 320, 30);
        }

        associateButton.setBounds(570, 15, 160, 20);
        associateButton.addActionListener(e -> OnAssociateButtonDown());

        confirmTranslationButton.setBounds(470, 15, 90, 20);
        confirmTranslationButton.addActionListener(e -> OnConfirmTranslationButtonDown());
        startMachineTranslation.setBounds(240, 15, 100, 20);


        formerPageButton.setBounds(505, 380, 90, 20);
        formerPageButton.addActionListener(e -> OnFormerPageButtonDown());
        nextPageButton.setBounds(665, 380, 90, 20);
        nextPageButton.addActionListener(e -> OnNextPageButtonDown());

        UpdateItemFields();
    }

    public void UpdateItemFields() {
        TranslationItem[] items = GetCurrentPageItems();
        UpdateItemFieldsByPage(items);
        UpdateBookPrint();
    }

    public void UpdateItemFieldsByPage(TranslationItem[] items) {
        if (items.length > itemFieldNum)
            System.err.println("Expected length: <=8, actual length: " + items.length);
        for (int i = 0; i < 2 * itemFieldNum; i++)
            texts[i].setText("");
        for (int i = 0; i < items.length; i++) {
            texts[2 * i].setText(items[i].origin.text);
            if (items[i].translation != null) {
                texts[2 * i + 1].setText(items[i].translation.text);
                states[i].setText("*");
            } else {
                states[i].setText("0");
            }
        }
    }

    private TranslationItem[] GetCurrentPageItems() {
        return Arrays.copyOfRange(translationItems,
                currentPageNum * itemFieldNum, Integer.min((currentPageNum + 1) * itemFieldNum, translationItems.length));
    }

    private void UpdateBookPrint() {
        bookPrint.setText((currentPageNum + 1) + "/" + (translationItems.length / itemFieldNum + 1));
    }

    private void OnFormerPageButtonDown() {
        if (currentPageNum > 0) {
            currentPageNum--;
            UpdateItemFields();
        }
    }

    private void OnNextPageButtonDown() {
        if (currentPageNum < translationItems.length / itemFieldNum) {
            currentPageNum++;
            UpdateItemFields();
        }
    }

    private void OnConfirmTranslationButtonDown() {
        if (focusNum != -1) {
            int index = focusNum + itemFieldNum * currentPageNum;
            ProjectManager.instance.currentTranslationFile.TranslateParagraph(
                    translationItems[index], texts[2 * focusNum + 1].getText());
            translationItems = ProjectManager.instance.currentTranslationFile.GetPureTranslationItem();
            if (ProjectManager.instance.currentProject.memoryLibrary != null) {
                ProjectManager.instance.currentProject.memoryLibrary.AddItem(translationItems[index]);
                MemoryLibraryManager.SaveLibrary(ProjectManager.instance.currentProject.memoryLibrary);
            }
            UpdateItemFields();
            TranslationFileManager.SaveFile(ProjectManager.instance.currentTranslationFile);
        }
    }

    private void UpdateMemoryLibraryMessage() {
        int index = focusNum + itemFieldNum * currentPageNum;
        memoryLibraryPanel.SetTextArea(
                ProjectManager.instance.currentProject.memoryLibrary.Match(translationItems[index].origin.text));
    }

    private void UpdateTermLibraryMessage() {
        int index = focusNum + itemFieldNum * currentPageNum;
        termLibraryPanel.SetTextArea(
                ProjectManager.instance.currentProject.GetTermLibraryMessages(translationItems[index].origin.text));
    }

    public void UseTranslateResult(String message) {
        if (focusNum != -1) {
            int index = focusNum + itemFieldNum * currentPageNum;
            ProjectManager.instance.currentTranslationFile.TranslateParagraph(
                    translationItems[index], message);
            translationItems = ProjectManager.instance.currentTranslationFile.GetPureTranslationItem();
            if (ProjectManager.instance.currentProject.memoryLibrary != null) {
                ProjectManager.instance.currentProject.memoryLibrary.AddItem(translationItems[index]);
                MemoryLibraryManager.SaveLibrary(ProjectManager.instance.currentProject.memoryLibrary);
            }
            UpdateItemFields();
            TranslationFileManager.SaveFile(ProjectManager.instance.currentTranslationFile);
        }
    }

    public void SpellCheck(String text) {
        if (ProjectManager.instance.currentTranslationFile.targetLanguage.EqualsTo(Language.English)) {
            spellCheckPanel.SetText(EditHelper.EnglishSpellCheck(text));
        }
    }

    public void AutoComplete(String text) {
        JTextField textField = texts[2 * focusNum + 1];
        textField.setText(EditHelper.AutoComplete(textField.getText(), text));
    }

    private void OnAssociateButtonDown() {
        new AssociationWindow(this, texts[2 * focusNum + 1].getText());
    }
}
