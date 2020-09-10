package com.example.android.newsapp;

/**
 * News
 */
public class News {
    private String sectionId;
    private String sectionName;
    private String publicationDate;
    private String authorName;
    private String title;
    private String url;

    /**
     * Ctor
     * @param sectionName
     * @param title
     * @param url
     */
    public News(String sectionName, String title, String url) {
        this.sectionName = sectionName;
        this.title = title;
        this.url = url;
    }

    /**
     * Section name getter
     * @return
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * Article title getter
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * URL to the article
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Section ID getter
     * @return
     */
    public String getSectionId() {
        return sectionId;
    }

    /**
     * Section ID setter
     * @param sectionId
     */
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * Article publication date getter
     * @return
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Article publication date setter
     * @param publicationDate
     */
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Article author name getter
     * @return
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Article author name setter
     * @param authorName
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
