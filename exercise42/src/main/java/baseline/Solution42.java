package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution42 {
    public static void main(String[] args) {
        Solution42 app = new Solution42();
        List<Employee> employeeList = new ArrayList<>();    //list holds employee objects

        try {
            BufferedReader reader = new BufferedReader(new FileReader("./data/exercise42_input.txt"));
            String currentLine = app.getFileLine(reader);
            while (currentLine != null) {
                String[] input = currentLine.split(",");    //split each line into last, first names and salaries
                Employee employee = new Employee(input[0], input[1], input[2]);     //create new employee object with constructor
                employeeList.add(employee);
                currentLine = app.getFileLine(reader);      //update reader to next line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        app.writeToFile(employeeList);    //write to output file
    }

    //read line from input file
    public String getFileLine(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    //write to output file
    public String writeToFile(List<Employee> employeeList) {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%-10s  %-10s  %-10s %n", "Last", "First", "Salary"));
        output.append("------------------------------\n");
        for (Employee employee : employeeList) {
            output.append(employee.outputString());
        }

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./data/exercise42_output.txt"))) {
                writer.write(String.valueOf(output));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(output);      //return string for testing purposes
    }
}
