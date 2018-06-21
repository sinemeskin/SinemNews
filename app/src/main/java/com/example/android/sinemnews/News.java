package com.example.android.sinemnews;

public class News {

    private String mTitle;
    private String mUrl;
    private String mDate;
    private String mSection;
    private String mAuthor;

    public News(String title, String url, String date, String section, String author) {

        mTitle = title;
        mUrl = url;
        mDate = date;
        mSection = section;
        mAuthor = author;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getDate() {
        return mDate;
    }

    public String getSection() {
        return mSection;
    }

    public String getAuthor() {
        return mAuthor;
    }

}

