/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Nader Fares
 */
/*
/*
Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.
 */
package baseline;

import java.util.Scanner;

public class Solution43 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Website w = new Website();

        //build output along the way
        StringBuilder output = w.output;

        //prompt for and store site name
        System.out.print("Site name: ");
        String siteName = input.nextLine();

        //create and return site directory
        String siteDirectory = w.createWebsiteDirectory(siteName);

        //prompt for and store author name
        System.out.print("Author: ");
        String authorName = input.nextLine();

        //create html website
        w.createWebsiteHTML(siteDirectory, siteName, authorName);

        //ask if they want js, create js folder if yes
        System.out.print("Do you want a folder for JavaScript? ");
        String jsFolder = input.nextLine();
        if (jsFolder.equalsIgnoreCase("y") || jsFolder.equalsIgnoreCase("yes")) {
            w.createWebsiteJs(siteDirectory);
        }

        //ask if they want css, create css folder if yes
        System.out.print("Do you want a folder for CSS? ");
        String cssFolder = input.nextLine();
        if (cssFolder.equalsIgnoreCase("y") || cssFolder.equalsIgnoreCase("yes")) {
            w.createWebsiteCss(siteDirectory);
        }

        //display output
        System.out.println(output);
    }
}
