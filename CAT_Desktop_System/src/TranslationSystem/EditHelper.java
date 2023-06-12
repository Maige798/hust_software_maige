package TranslationSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditHelper {
    public static final String dictionary = "System Files\\dictionary.dict";

    public String[] EnglishWords;

    public static EditHelper instance = new EditHelper();

    private EditHelper() {
        SetUpDictionary();
    }

    public static String EnglishSpellCheck(String message) {
        String[] wrongWords = GetWrongWords(message);
        if (wrongWords.length == 0)
            return "No Errors\r\n";
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < wrongWords.length; i++)
                builder.append(i + 1).append(".").append(wrongWords[i]).append("\r\n");
            return builder.toString();
        }
    }

    public static String[] GetWrongWords(String message) {
        List<String> wrongWordsList = new ArrayList<>();
        String[] messages = message.split("[^A-Za-z-']");
        for (String s : messages)
            if (!IsCorrect(s))
                wrongWordsList.add(s);
        return wrongWordsList.toArray(new String[0]);
    }

    public static String EnglishAssociate(String message) {
        String[] associationWords = GetEnglishAssociationWords(message);
        if (associationWords.length == 0)
            return "No Advice";
        else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < associationWords.length; i++)
                builder.append(i + 1).append(".").append(associationWords[i]).append("\r\n");
            return builder.toString();
        }
    }

    public static String AutoComplete(String source,String replace) {
        String[] sources = source.split("[^A-Za-z-']");
        int index = source.indexOf(sources[sources.length - 1]);
        return source.substring(0, index) + replace;
    }

    public static boolean IsCorrect(String message) {
        if (message.equals(""))
            return true;
        for (String word : instance.EnglishWords)
            if (message.toLowerCase().equals(word))
                return true;
        return false;
    }

    public void SetUpDictionary() {
        try (FileReader in = new FileReader(dictionary)) {
            int charGet;
            StringBuilder builder = new StringBuilder();
            while ((charGet = in.read()) != -1)
                builder.append((char) charGet);
            EnglishWords = builder.toString().split("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] GetEnglishAssociationWords(String message) {
        String[] messages = message.split("[^A-Za-z-']");
        String target = messages[messages.length - 1];
        List<String> associationList = new ArrayList<>();
        for (String word : instance.EnglishWords)
            if (word.indexOf(target) == 0)
                associationList.add(word);
        return associationList.toArray(new String[0]);
    }
}
