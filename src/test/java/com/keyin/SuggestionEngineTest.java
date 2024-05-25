package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Paths;

public class SuggestionEngineTest {

    @Test
    void loadsTestDictionary() throws IOException {
        SuggestionEngine engine = new SuggestionEngine();
        engine.loadDictionaryData(Paths.get("src/main/resources/words.txt"));

        assertFalse(engine.getWordSuggestionDB().isEmpty());
    }


    @Test
    void testWordExistsInDictionary() throws IOException {
        SuggestionEngine engine = new SuggestionEngine();
        engine.loadDictionaryData(Paths.get("src/main/resources/words.txt"));

        assertTrue(engine.getWordSuggestionDB().containsKey("hello"));
    }

    @Test
    void testSuggestionGeneration() throws IOException {
        SuggestionEngine engine = new SuggestionEngine();
        engine.loadDictionaryData(Paths.get("src/main/resources/words.txt"));
        String testWord = "helo";

        String suggestions = engine.generateSuggestions(testWord);

        assertFalse(suggestions.isEmpty());

    }
}
