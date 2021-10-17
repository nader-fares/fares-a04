package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {

    @Test
    void createHistogram() {
        Solution46 app = new Solution46();
        Word word = new Word("badger", 7);

        String actualOutcome = app.createHistogram(word);
        String expectedString = String.format("%-10s", "badger:") + "*******";

        assertEquals(expectedString, actualOutcome);
    }

    @Test
    void checkForObject() {
        Solution46 app = new Solution46();
        List<Word> wordList = new ArrayList<>();
        wordList.add(new Word("badger", 1));
        wordList.add(new Word("mushroom", 1));
        wordList.add(new Word("snake", 1));

        String currentWord = "wolf";

        boolean actualOutcome = app.checkForObject(wordList, currentWord);
        boolean expectedOutcome = false;

        assertEquals(expectedOutcome, actualOutcome);  //weak warning is for not simplifying to assertFalse (which is not what's being tested)
    }
}