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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution43 {
    static final String CREATED = "Created ";       //to avoid retyping same term multiple times

    public static void main(String[] args) {
        Solution43 app = new Solution43();
        Scanner input = new Scanner(System.in);

        //build output along the way
        StringBuilder output = new StringBuilder();
        Website site = new Website();

        //prompt for and store site name
        System.out.print("Site name: ");
        site.setSiteName(input.nextLine());

        //create and return site directory
        site.setSiteDirectory(app.createWebsiteDirectory(site.getSiteName(), output));

        //prompt for and store author name
        System.out.print("Author: ");
        site.setAuthorName(input.nextLine());

        //create html website
        app.createWebsiteHTML(site.getSiteDirectory(), site.getSiteName(), site.getAuthorName(), output);

        //ask if they want js, create js folder if yes
        System.out.print("Do you want a folder for JavaScript? ");
        site.setJsFolder(input.nextLine());
        if (site.getJsFolder().equalsIgnoreCase("y") || site.getJsFolder().equalsIgnoreCase("yes")) {
            app.createWebsiteJs(site.getSiteDirectory(), output);
        }

        //ask if they want css, create css folder if yes
        System.out.print("Do you want a folder for CSS? ");
        site.setCssFolder(input.nextLine());
        if (site.getCssFolder().equalsIgnoreCase("y") || site.getCssFolder().equalsIgnoreCase("yes")) {
            app.createWebsiteCss(site.getSiteDirectory(), output);
        }

        //display output
        System.out.println(output);
    }

    //create file directory using input site name
    public String createWebsiteDirectory(String siteName, StringBuilder output) {
        String siteDirectory = "./data/website/" + siteName;
        File filePath = new File(siteDirectory);
        if (!filePath.exists()) {
            boolean wasSuccessful = filePath.mkdirs();
            if (wasSuccessful)
                output.append(CREATED).append(siteDirectory).append("\n");        //build output
        }
        return siteDirectory;        //return directory
    }

    //create website html
    public void createWebsiteHTML(String siteNameDir, String siteName, String authorName, StringBuilder output) {
        try {
            File file = new File(siteNameDir + "/index.html");

            if (!file.exists()) {
                boolean wasSuccessful = file.createNewFile();
                if (wasSuccessful)
                    output.append(CREATED).append(siteNameDir).append("/index.html\n");        //build output
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<title>" + siteName + "</title>");        //site name between <main> tags
            pw.println("<meta name=\"author\" content=\"" + authorName + "\">");        //author name between <meta> tags
            pw.println("</head>");
            pw.println("<body>");
            pw.println("</body>");
            pw.println("</html>");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create js folder
    public void createWebsiteJs(String siteNameDir, StringBuilder output) {
        File fileJS = new File(siteNameDir + "/js");
        if (!fileJS.exists()) {
            boolean wasSuccessful = fileJS.mkdirs();
            if (wasSuccessful)
                output.append(CREATED).append(siteNameDir).append("/js\n");        //build output
        }
    }

    //create css folder
    public void createWebsiteCss(String siteNameDir, StringBuilder output) {
        File fileJS = new File(siteNameDir + "/css");
        if (!fileJS.exists()) {
            boolean wasSuccessful = fileJS.mkdirs();
            if (wasSuccessful)
                output.append(CREATED).append(siteNameDir).append("/css\n");        //build output
        }
    }
}
