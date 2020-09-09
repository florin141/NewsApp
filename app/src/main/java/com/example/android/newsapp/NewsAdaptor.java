package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.newsapp.models.News;

import java.util.ArrayList;

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

        TextView titleTextView = (TextView) convertView.findViewById(R.id.title);
        titleTextView.setText(currentNews.getTitle());

        return convertView;
    }
}
