/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
/*
Create a program that reads in a file named `exercise46_input.txt` and
counts the frequency of words in the file.
Then construct a histogram displaying
    the words and
    the frequency, and
    display the histogram to the screen.
 */
package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) {
        Solution46 app = new Solution46();

        File file = new File("./data/exercise46_input.txt");
        //declare list of Word objects
        List<Word> wordList = new ArrayList<>();

        //read from input file
        try {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String currentWord = input.next();

                    boolean doesExist = app.checkForObject(wordList, currentWord);        //check if object for word already exists

                    //if word does not exist in list, create word object
                    if (!doesExist)
                        wordList.add(new Word(currentWord, 1));                // add word object to object list
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        wordList.sort(Comparator.comparing(Word::getOccurrenceCounter).reversed());        //sort list by highest counter

        for (Word word : wordList) {        //display every word in list
            System.out.println(app.createHistogram(word));      //display histogram of word and frequency
            System.out.println("\n");
        }
    }

    //create histogram of word and frequency
    public String createHistogram(Word word) {

        // return for testing purposes
        return String.format("%-10s", word.getName() + ":") +
                "*".repeat(Math.max(0, word.occurrenceCounter));            //print * for amount of word counter
    }

    public boolean checkForObject(List<Word> wordList, String currentWord) {
        for (Word word : wordList) {
            if (currentWord.equalsIgnoreCase(word.getName())) {
                word.occurrenceCounter++;            //if word object exists update object counter
                return true;        //word does exist
            }
        }
        return false;   //word does not exist
    }
}
