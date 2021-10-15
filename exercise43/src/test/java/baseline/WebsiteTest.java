package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {

    @Test
    void createWebsiteDirectory() {
        Solution43 app = new Solution43();

        StringBuilder output = new StringBuilder();
        String expectedSiteDirectory = "./data/website/awesomeco";
        String siteName = "awesomeco";

        String actualSiteDirectory = app.createWebsiteDirectory(siteName, output);

        assertEquals(expectedSiteDirectory, actualSiteDirectory);
    }

    @Test
    void createWebsiteHTML() {
        Solution43 app = new Solution43();

        StringBuilder output = new StringBuilder();
        String siteDirectory = "./data/website/awesomeco";
        String siteName = "awesomeco";
        String authorName = "Max Power";
        app.createWebsiteHTML(siteDirectory, siteName, authorName, output);

        File file = new File("./data/website/awesomeco/index.html");
        assertTrue(file.exists());
    }

    @Test
    void createWebsiteJs() {
        Solution43 app = new Solution43();

        StringBuilder output = new StringBuilder();
        String siteDirectory = "./data/website/awesomeco";
        app.createWebsiteJs(siteDirectory, output);

        File file = new File("./data/website/awesomeco/js");
        assertTrue(file.exists());
    }

    @Test
    void createWebsiteCss() {
        Solution43 app = new Solution43();

        StringBuilder output = new StringBuilder();
        String siteDirectory = "./data/website/awesomeco";
        app.createWebsiteCss(siteDirectory, output);

        File file = new File("./data/website/awesomeco/css");
        assertTrue(file.exists());
    }
}