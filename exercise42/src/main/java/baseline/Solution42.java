/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
/*
Construct a program that reads in the following data file (you will need to create this data file yourself; name it `exercise42_input.txt`):
Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.
Write your own code to parse the data. Don't use a CSV parser.
 */

package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution42 {
    public static void main(String[] args) {
        Solution42 app = new Solution42();

        //declare list to store employees
        List<String> employees = new ArrayList<>();

        //declare lists to store last, first names and salaries
        List<String> lastName = new ArrayList<>();
        List<String> firstName = new ArrayList<>();
        List<String> salary = new ArrayList<>();

        app.readFromFile(employees);

        app.employeeParser(employees, lastName, firstName, salary);

        app.writeToFile(lastName, firstName, salary);
    }

    //read names from input file
    public void readFromFile(List<String> employees) {
        //add each employee to list
        String currentLine;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("..\\exercise42\\data\\exercise42_input.txt"))) {
                while ((currentLine = reader.readLine()) != null) {        //use loop to iterate through each line
                    employees.add(currentLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //write to output file
    public String writeToFile(List<String> lastName, List<String> firstName, List<String> salary) {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%-10s  %-10s  %-10s %n", "Last", "First", "Salary"));
        output.append(String.format("------------------------------%n"));
        for(int i = 0; i < firstName.size(); i++) {
            output.append(String.format("%-10s", lastName.get(i)));
            output.append(String.format("  %-10s", firstName.get(i)));
            output.append(String.format("  %-10s%n",salary.get(i)));
        }

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("..\\exercise42\\data\\exercise42_output.txt"))) {
                writer.write(String.valueOf(output));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(output);
    }

    public void employeeParser(List <String> employees, List <String> lastName, List <String> firstName, List <String> salary) {
        String[] input;         //hold separated employee strings

        for (String em : employees) {
            input = em.split(",");        //separate each line
            lastName.add(input[0]);
            firstName.add(input[1]);
            salary.add(input[2]);        //store into separated lists
        }
    }
}
