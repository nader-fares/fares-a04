package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    List<String> employees = new ArrayList<>();
    List<String> lastName = new ArrayList<>();
    List<String> firstName = new ArrayList<>();
    List<String> salary = new ArrayList<>();

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
