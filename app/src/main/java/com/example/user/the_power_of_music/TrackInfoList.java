package com.example.user.the_power_of_music;

/**
 * Created by paul on 2018. 3. 16..
 */

public class TrackInfoList {
    private int trackIndex;
    private String trackName;

    public TrackInfoList(int trackIndex, String trackName) {
        this.trackIndex = trackIndex;
        this.trackName = trackName;
    }

    public int getTrackIndex() {
        return trackIndex;
    }

    public void setTrackIndex(int trackIndex) {
        this.trackIndex = trackIndex;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
