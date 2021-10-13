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

import java.util.List;

public class Solution42 {
    public static void main(String[] args) {
        Employee em = new Employee();
        //declare list to store employees

        List<String> employee = em.employees;
        //declare lists to store last, first names and salaries
        List<String> l = em.lastName;
        List<String> f = em.firstName;
        List<String> s = em.salary;

        em.readFromFile(employee);

        em.employeeParser(employee, l, f, s);

        em.writeToFile(l, f, s);


    }






}
