package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {

    @Test
    void readAndReplace() {
        Solution45 app = new Solution45();

        String outputActual = app.readAndReplace();

        String outputExpected = """
                One should never use the word "use" in writing. Use "use" instead.
                For example, "She uses an IDE to write her Java programs" instead of "She
                uses an IDE to write her Java programs".
                """;

        assertEquals(outputExpected, outputActual);
    }

    @Test
    void writeToFile() {
        Solution45 app = new Solution45();
        File fileExpected = new File("./data/output.txt");

        String outputFile = "output";
        String output = "";
        app.writeToFile(outputFile, output);

        assertTrue(fileExpected.exists());  //output file was created
    }
}