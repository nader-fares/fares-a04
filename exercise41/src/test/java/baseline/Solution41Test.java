package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @Test
    void readFromFile() {
        Person person = new Person();
        List<String> names = new ArrayList<>();

        List<String> namesTest = new ArrayList<>();
        namesTest.add("Ling, Mai");
        namesTest.add("Johnson, Jim");
        namesTest.add("Zarnecki, Sabrina");
        namesTest.add("Jones, Chris");
        namesTest.add("Jones, Aaron");
        namesTest.add("Swift, Geoffrey");
        namesTest.add("Xiong, Fong");


        person.readFromFile(names);

        assertEquals(namesTest, names);
    }

    @Test
    void writeToFile() {
        Person person = new Person();
        List<String> names = new ArrayList<>();

        person.readFromFile(names);
        Collections.sort(names);
        String outputActual = person.writeToFile(names);

        List<String> namesTest = new ArrayList<>();
        namesTest.add("Johnson, Jim\n");
        namesTest.add("Jones, Aaron\n");
        namesTest.add("Jones, Chris\n");
        namesTest.add("Ling, Mai\n");
        namesTest.add("Swift, Geoffrey\n");
        namesTest.add("Xiong, Fong\n");
        namesTest.add("Zarnecki, Sabrina\n");
        StringBuilder outputTest = new StringBuilder();
        outputTest.append("Total of 7 names\n");
        outputTest.append("-----------------\n");
        for (String test: namesTest) {
            outputTest.append(test);
        }

        assertEquals(String.valueOf(outputTest), outputActual);
    }
}