package com.example.android.newsapp.models;

public class Section {
    private String id;
    private String title;

    public Section(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
