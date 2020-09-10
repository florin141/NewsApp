package com.example.android.newsapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class NewsAdaptor extends ArrayAdapter<News> {

    private static final String LOG_TAG = NewsAdaptor.class.getSimpleName();

    public NewsAdaptor(@NonNull Context context, @NonNull ArrayList<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView sectionTextView = convertView.findViewById(R.id.section);
        sectionTextView.setText(currentNews.getSectionName());

        TextView titleTextView = convertView.findViewById(R.id.title);
        titleTextView.setText(currentNews.getTitle());

        String date = currentNews.getPublicationDate();
        if (date != null && !date.isEmpty()) {
            TextView dateTextView = convertView.findViewById(R.id.date);
            dateTextView.setText(date);
        }

        String authorName = currentNews.getAuthorName();
        if (authorName != null && !authorName.isEmpty()) {
            TextView authorTextView = convertView.findViewById(R.id.author);
            authorTextView.setText(authorName);
        }

        FrameLayout articleBg = convertView.findViewById(R.id.section_background);
        articleBg.setBackgroundColor(getRandomColor(currentNews));

        return convertView;
    }

    public int getRandomColor(News news) {
        Random rnd = new Random();

        int hash = news.getSectionId().hashCode() % 255;

        return Color.argb(255, hash, hash, hash);
    }
}
