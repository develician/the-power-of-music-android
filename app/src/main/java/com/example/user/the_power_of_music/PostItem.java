package com.example.user.the_power_of_music;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by USER on 2018-03-13.
 */

public class PostItem {
    private ArrayList<String> name;
    private ArrayList<String> track;
    private String title;
    private String body;
    private String artist;
    private String publishedDate;
    private String cover;
    private ArrayList<String> tags;

    public PostItem(ArrayList<String> name, ArrayList<String> track, String title, String body, String artist, String publishedDate, String cover, ArrayList<String> tags) {
        this.name = name;
        this.track = track;
        this.title = title;
        this.body = body;
        this.artist = artist;
        this.publishedDate = publishedDate;
        this.cover = cover;
        this.tags = tags;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getTrack() {
        return track;
    }

    public void setTrack(ArrayList<String> track) {
        this.track = track;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
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
