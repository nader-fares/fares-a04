package baseline;

import java.io.*;
import java.util.Scanner;

public class Solution45 {
    public static void main(String[] args) {
        Solution45 app = new Solution45();
        Scanner input = new Scanner(System.in);

        //read from input file
        String outputString = app.readAndReplace();                //build output

        //prompt for output file name
        System.out.print("Enter the name of the output file: ");
        String outputFile = input.nextLine();

        //write output to file
        app.writeToFile(outputFile, outputString);
    }

    //read from input file
    public String readAndReplace() {
        //read file
        File file = new File("./data/input.txt");
        StringBuilder output = new StringBuilder();
        try {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String currentLine = input.nextLine();
                    if (currentLine.contains("utilize"))        //replace all instances of utilize with use
                        currentLine = currentLine.replace("utilize", "use");
                    output.append(currentLine).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return String.valueOf(output);        //return output
    }

    //write output to file
    public void writeToFile(String outputFile, String output) {
        File file = new File("./data/" + outputFile + ".txt");

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
