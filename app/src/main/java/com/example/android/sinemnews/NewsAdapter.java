package com.example.android.sinemnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOCATION_SEPARATOR_MID = "-";
    private static final String LOCATION_SEPARATOR_END = "T";

    public NewsAdapter(Context context, List<News> news) {

        super(context, 0, news);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);

        }

        News currentNews = getItem(position);

        String originalDate = currentNews.getDate();
        String newDate;
        String year;
        String month;
        String day;
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        if (originalDate.contains(LOCATION_SEPARATOR_MID)) {
            String[] parts = originalDate.split(LOCATION_SEPARATOR_MID);
            year = parts[0];
            month = months[Integer.parseInt(parts[1]) - 1];
            day = parts[2];

            if (day.contains(LOCATION_SEPARATOR_END)) {
                String[] dayParts = day.split(LOCATION_SEPARATOR_END);
                day = dayParts[0];
            } else {
                newDate = null;
            }

            newDate = month + " " + day + ", " + year;

        } else {
            newDate = null;
        }

        String originalAuthor;

        if (currentNews.getAuthor() == null) {
            originalAuthor = "Author is not declared.";
        } else {
            originalAuthor = currentNews.getAuthor();
        }

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(newDate);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        sectionView.setText(currentNews.getSection());

        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(originalAuthor);

        return listItemView;

    }


}


