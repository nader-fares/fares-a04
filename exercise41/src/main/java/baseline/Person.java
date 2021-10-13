package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Person {
    //Declare list to store names
    List<String> names = new ArrayList<>();

    //read names from input file
    public void readFromFile(List<String> names) {
        String currentLine;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("..\\exercise41\\data\\exercise41_input.txt"))) {
                while ((currentLine = reader.readLine()) != null) {        //use loop to iterate through each line
                    names.add(currentLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write names onto output file
    public String writeToFile(List <String> names) {
        int length = names.size();

        //build output
        StringBuilder output = new StringBuilder();
        output.append("Total of ").append(length).append(" names\n");
        output.append("-----------------\n");
        for (String name : names)
            output.append(name).append("\n");

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\exercise41\\data\\exercise41_output.txt"))) {
                writer.write(String.valueOf(output));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(output);    //return string for testing purposes
    }
}
