package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {

    @Test
    void createWebsiteDirectory() {
        Website w = new Website();

        String expectedSiteDirectory = "..\\exercise43\\data\\website\\awesomeco";
        String siteName = "awesomeco";

        String actualSiteDirectory = w.createWebsiteDirectory(siteName);

        assertEquals(expectedSiteDirectory, actualSiteDirectory);
    }
}