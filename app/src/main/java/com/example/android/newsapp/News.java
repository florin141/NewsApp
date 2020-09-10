package com.example.android.newsapp;

public class News {
    private String sectionId;
    private String sectionName;
    private String publicationDate;
    private String authorName;
    private String title;
    private String url;

    public News(String sectionName, String title, String url) {
        this.sectionName = sectionName;
        this.title = title;
        this.url = url;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
