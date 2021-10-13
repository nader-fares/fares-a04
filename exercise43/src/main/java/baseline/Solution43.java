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

public class Solution43 {
    public static void main(String[] args) {
        //build output along the way
        StringBuilder output;

        //prompt for and store site name
        String siteName;

        //create and return site directory
        String siteDirectory = createWebsiteDirectory();

        //prompt for and store author name
        String authorName;

        //create html website
        createWebsiteHTML();

        //ask if they want js
        String jsFolder;
        //if yes, create js folder
        createWebsiteJs();

        //ask if they want css
        String cssFolder;
        //if yes, create js folder
        createWebsiteCss();

        //display output
    }
}
