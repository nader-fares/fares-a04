package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution42Test {

    @Test
    void readFromFile() {
        Employee em = new Employee();
        List<String> employees = new ArrayList<>();
        em.readFromFile(employees);

        List<String> employeeExpected = new ArrayList<>();
        employeeExpected.add("Ling,Mai,55900");
        employeeExpected.add("Johnson,Jim,56500");
        employeeExpected.add("Jones,Aaron,46000");
        employeeExpected.add("Jones,Chris,34500");
        employeeExpected.add("Swift,Geoffrey,14200");
        employeeExpected.add("Xiong,Fong,65000");
        employeeExpected.add("Zarnecki,Sabrina,51500");

        assertEquals(employeeExpected, employees);
    }

    @Test
    void writeToFile() {
        Employee em = new Employee();

        List<String> employees = new ArrayList<>();
        List<String> lastName = new ArrayList<>();
        List<String> firstName = new ArrayList<>();
        List<String> salary = new ArrayList<>();

        em.readFromFile(employees);

        em.employeeParser(employees, lastName, firstName, salary);

        String outputActual = em.writeToFile(lastName, firstName, salary);

        String outputExpected = String.format("%-10s  %-10s  %-10s %n", "Last", "First", "Salary") +
                String.format("------------------------------%n") +
                """
                        Ling        Mai         55900    \s
                        Johnson     Jim         56500    \s
                        Jones       Aaron       46000    \s
                        Jones       Chris       34500    \s
                        Swift       Geoffrey    14200    \s
                        Xiong       Fong        65000    \s
                        Zarnecki    Sabrina     51500    \s
                        """;
        assertEquals(String.valueOf(outputExpected), outputActual);
    }

    @Test
    void employeeParser() {
        Employee em = new Employee();

        List<String> employees = new ArrayList<>();
        List<String> lastName = new ArrayList<>();
        List<String> firstName = new ArrayList<>();
        List<String> salary = new ArrayList<>();
        em.readFromFile(employees);
        em.employeeParser(employees, lastName, firstName, salary);

        List<String> lastNameExpected = new ArrayList<>();
        lastNameExpected.add("Ling");
        lastNameExpected.add("Johnson");
        lastNameExpected.add("Jones");
        lastNameExpected.add("Jones");
        lastNameExpected.add("Swift");
        lastNameExpected.add("Xiong");
        lastNameExpected.add("Zarnecki");

        List<String> firstNameExpected = new ArrayList<>();
        firstNameExpected.add("Mai");
        firstNameExpected.add("Jim");
        firstNameExpected.add("Aaron");
        firstNameExpected.add("Chris");
        firstNameExpected.add("Geoffrey");
        firstNameExpected.add("Fong");
        firstNameExpected.add("Sabrina");

        List<String> salaryExpected = new ArrayList<>();
        salaryExpected.add("55900");
        salaryExpected.add("56500");
        salaryExpected.add("46000");
        salaryExpected.add("34500");
        salaryExpected.add("14200");
        salaryExpected.add("65000");
        salaryExpected.add("51500");

        assertEquals(lastNameExpected, lastName);
        assertEquals(firstNameExpected, firstName);
        assertEquals(salaryExpected, salary);

    }
}