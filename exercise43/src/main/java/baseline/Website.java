package baseline;

public class Website {
    private String siteName;
    private String siteDirectory;
    private String authorName;
    private String jsFolder;
    private String cssFolder;

    public String getSiteName() {
        return siteName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getJsFolder() {
        return jsFolder;
    }

    public String getCssFolder() {
        return cssFolder;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDirectory() {
        return siteDirectory;
    }

    public void setSiteDirectory(String siteDirectory) {
        this.siteDirectory = siteDirectory;
    }


    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setJsFolder(String jsFolder) {
        this.jsFolder = jsFolder;
    }


    public void setCssFolder(String cssFolder) {
        this.cssFolder = cssFolder;
    }

}
