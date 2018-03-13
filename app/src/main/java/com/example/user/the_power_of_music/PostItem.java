package com.example.user.the_power_of_music;

/**
 * Created by USER on 2018-03-13.
 */

public class PostItem {
    private String title;
    private String body;
    private String artist;
    private String publishedDate;
    private String cover;

    public PostItem(String title, String body, String artist, String publishedDate, String cover) {
        this.title = title;
        this.body = body;
        this.artist = artist;
        this.publishedDate = publishedDate;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
