package model;

public class ArticleInfo {

    private String origin;
    private String url;
    private String title;
    private String content;

    public ArticleInfo() {
        this.origin = "Nguyen Van Manh";
    }

    public ArticleInfo(String origin, String url, String title, String content) {
        this.origin = origin;
        this.url = url;
        this.title = title;
        this.content = content;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
