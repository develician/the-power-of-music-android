package com.example.user.the_power_of_music;

/**
 * Created by paul on 2018. 3. 18..
 */

public class TrackInfo {
    String index;
    String trackName;
    String trackFile;


    public TrackInfo(String index, String trackName, String trackFile) {
        this.index = index;
        this.trackName = trackName;
        this.trackFile = trackFile;
    }

    public String getTrackFile() {
        return trackFile;
    }

    public void setTrackFile(String trackFile) {
        this.trackFile = trackFile;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
