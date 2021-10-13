package baseline;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Website {
    StringBuilder output = new StringBuilder();
    String created = "Created ";
    //create file directory using input site name
    public String createWebsiteDirectory(String siteName) {
        String siteDirectory = "..\\exercise43\\data\\website\\" + siteName;
        File filePath = new File(siteDirectory);
        if (!filePath.exists()){
            boolean wasSuccessful = filePath.mkdirs();
            if (wasSuccessful)
                output.append(created).append(siteDirectory).append("\n");        //build output
        }
        return siteDirectory;        //return directory
    }

    //create website html
    public void createWebsiteHTML(String siteNameDir, String siteName, String authorName) {
        try {
            File file = new File(siteNameDir + "\\index.html");

            if (!file.exists()) {
                boolean wasSuccessful = file.createNewFile();
                if (wasSuccessful)
                    output.append(created).append(siteNameDir).append("\\index.html\n");        //build output
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("<main>" + siteName + "</main>");        //site name between <main> tags
            pw.println("<meta>" + authorName + "</meta>");        //author name between <meta> tags
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //create js folder
    public void createWebsiteJs(String siteNameDir) {
            File fileJS = new File(siteNameDir + "\\js");
            if (!fileJS.exists()) {
                boolean wasSuccessful = fileJS.mkdirs();
                if (wasSuccessful)
                    output.append(created).append(siteNameDir).append("\\js\n");        //build output
            }
        }

    //create css folder
    public void createWebsiteCss(String siteNameDir) {
        File fileJS = new File(siteNameDir + "\\css");
        if (!fileJS.exists()) {
            boolean wasSuccessful = fileJS.mkdirs();
            if (wasSuccessful)
                output.append(created).append(siteNameDir).append("\\css\n");        //build output
        }
    }
}
