/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
/*
Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:
Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
 */
package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution41 {
    public static void main(String[] args) {
        Solution41 app = new Solution41();
        //Declare list to store names
        List<String> names = new ArrayList<>();

        app.readFromFile(names);

        //sort names
        Collections.sort(names);

        app.writeToFile(names);
    }

    //read names from input file
    public void readFromFile(List <String> names) {
        String currentLine;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("..\\data\\exercise41_input.txt"))) {
                while ((currentLine = reader.readLine()) != null) {        //use loop to iterate through each line
                    names.add(currentLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write names onto output file
    public void writeToFile(List <String> names) {

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\data\\exercise41_output.txt"))) {
                for (String name : names)
                    writer.write(name + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}