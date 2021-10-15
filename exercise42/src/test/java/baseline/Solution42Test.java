package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    @Test
    void getFileLine() {
        Solution42 app = new Solution42();

        String outputExpected = "Ling,Mai,55900";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./data/exercise42_input.txt"));
            String outputActual = app.getFileLine(reader);
            System.out.println(outputActual);
            assertEquals(outputExpected, outputActual);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    @Test
    void writeToFile() {
        Solution42 app = new Solution42();
        Employee employee = new Employee("Ling","Mai", "55900");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        String outputActual = app.writeToFile(employeeList);


        String outputExpected = String.format("%-10s  %-10s  %-10s %n", "Last", "First", "Salary");
        outputExpected += "------------------------------\n";
        outputExpected += String.format("%-10s  %-10s  %-10s %n", "Ling", "Mai", "55900");

        assertEquals(outputExpected, outputActual);
    }

}