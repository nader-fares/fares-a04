/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
/*
Create a program that reads in the following list of names from a file called `exercise41_input.txt` and sorts the list alphabetically:
Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.
 */
package baseline;

import java.util.Collections;
import java.util.List;

public class Solution41 {
    public static void main(String[] args) {
        Person person = new Person();

        List<String> personList = person.names;

        person.readFromFile(personList);

        //sort names
        Collections.sort(personList);

        person.writeToFile(personList);
    }
}

