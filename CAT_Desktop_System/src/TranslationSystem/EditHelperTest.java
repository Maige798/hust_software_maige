package TranslationSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditHelperTest {
    String text="Renenber," +
            " life mey not always be a bed of roses," +
            " but with the right mindset and determination," +
            " we can overbcome any obstacle that comes our way.";

    @Test
    void englishSpellCheck() {
        System.out.println(EditHelper.EnglishSpellCheck(text));
    }
}