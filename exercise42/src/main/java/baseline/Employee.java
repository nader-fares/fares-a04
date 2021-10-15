package baseline;

public class Employee {
    String lastName;
    String firstName;
    String salary;

    Employee(String lastName, String firstName, String salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
    }


    //make sure every line is formatted correctly
    public String outputString() {
        return String.format("%-10s  %-10s  %-10s %n", this.lastName, this.firstName, this.salary);
    }
}
