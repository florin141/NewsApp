package com.example.android.newsapp.models;

import androidx.annotation.NonNull;

public class News {
    private String Id;
    private String Type;
    private String SectionName;
    private String PublicationDate;
    private String Title;
    private String Url;

    public News() {}

    public News(String id, String type, String sectionName, String publicationDate, String title, String url) {
        Id = id;
        Type = type;
        SectionName = sectionName;
        PublicationDate = publicationDate;
        Title = title;
        Url = url;
    }

    public String getId() {
        return Id;
    }

    public String getType() {
        return Type;
    }

    public String getSectionName() {
        return SectionName;
    }

    public String getPublicationDate() {
        return PublicationDate;
    }

    public String getTitle() {
        return Title;
    }

    public String getUrl() {
        return Url;
    }

    @NonNull
    @Override
    public String toString() {
        return "News{" +
                "Id='" + Id + '\'' +
                ", Type='" + Type + '\'' +
                ", SectionName='" + SectionName + '\'' +
                ", PublicationDate=" + PublicationDate +
                ", Title='" + Title + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
