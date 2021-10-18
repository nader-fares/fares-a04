package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    void readFromFile() {
        Solution41 app = new Solution41();
        List<String> names = new ArrayList<>();

        List<String> namesTest = new ArrayList<>();
        namesTest.add("Ling, Mai");
        namesTest.add("Johnson, Jim");
        namesTest.add("Zarnecki, Sabrina");
        namesTest.add("Jones, Chris");
        namesTest.add("Jones, Aaron");
        namesTest.add("Swift, Geoffrey");
        namesTest.add("Xiong, Fong");


        app.readFromFile(names);

        assertEquals(namesTest, names);
    }

    @Test
    void writeToFile() {
        Solution41 app = new Solution41();
        String output = "";

        File file = new File("./data/exercise41_output.txt");
        app.writeToFile(output);

        assertTrue(file.exists());
    }
}