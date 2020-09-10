package com.example.android.newsapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.NewsHolder> {

    private static final String LOG_TAG = NewsAdaptor.class.getSimpleName();

    private List<News> newsList;

    public NewsAdaptor(ArrayList<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.news_item, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = newsList.get(position);
        holder.setSectionName(news.getSectionName());
        holder.setTitle(news.getTitle());

        String date = news.getPublicationDate();
        if (date != null && !date.isEmpty()) {
            holder.setPublishedDate(date);
        }

        String authorName = news.getAuthorName();
        if (authorName != null && !authorName.isEmpty()) {
            holder.setAuthorName(authorName);
        }

        holder.setArticleBackground(news);
    }

    public int getItemCount() {
        return newsList.size();
    }

    public void clear() {
        this.newsList.clear();
    }

    public void addAll(List<News> newsList) {
        this.newsList.addAll(newsList);
    }

    class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final String TAG = NewsHolder.class.getName();

        private TextView sectionTextView;
        private TextView titleTextView;
        private TextView dateTextView;
        private TextView authorTextView;
        private FrameLayout articleBg;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            sectionTextView = itemView.findViewById(R.id.section);
            titleTextView = itemView.findViewById(R.id.title);
            dateTextView = itemView.findViewById(R.id.date);
            authorTextView = itemView.findViewById(R.id.author);
            articleBg = itemView.findViewById(R.id.section_background);
        }

        public void setSectionName(String sectionName) {
            this.sectionTextView.setText(sectionName);
        }

        public void setTitle(String title) {
            titleTextView.setText(title);
        }

        public void setPublishedDate(String date) {
            dateTextView.setText(date);
        }

        public void setAuthorName(String fullName) {
            authorTextView.setText(fullName);
        }

        public void setArticleBackground(News news) {
            articleBg.setBackgroundColor(getRandomColor(news));
        }

        // For now it generates a random color for based on the sectionId
        // The idea here would be to have a set color for each
        // section, i.e. for environment green and so on
        public int getRandomColor(News news) {
            Random rnd = new Random();

            int hash = news.getSectionId().hashCode() % 255;

            return Color.argb(255, hash, hash, hash);
        }

        @Override
        public void onClick(View view) {
            // Find the current earthquake that was clicked on
            News currentNews = newsList.get(getAdapterPosition());

            // Convert the String URL into a URI object (to pass into the Intent constructor)
            Uri earthquakeUri = Uri.parse(currentNews.getUrl());

            // Create a new intent to view the earthquake URI
            Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

            // Send the intent to launch a new activity
            view.getContext().startActivity(websiteIntent);
        }
    }
}
