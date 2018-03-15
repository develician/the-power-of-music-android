package com.example.user.the_power_of_music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by paul on 2018. 3. 16..
 */

public class TrackInfoListAdapter extends BaseAdapter {
    Context context;
    ArrayList<TrackInfoList> trackInfoListArrayList;

    TextView trackIndex;
    TextView trackName;

    public TrackInfoListAdapter(Context context, ArrayList<TrackInfoList> trackInfoListArrayList) {
        this.context = context;
        this.trackInfoListArrayList = trackInfoListArrayList;
    }

    @Override
    public int getCount() {
        return this.trackInfoListArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.trackInfoListArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.track_info_list, null);

            trackIndex = (TextView) view.findViewById(R.id.trackIndex);
            trackName = (TextView) view.findViewById(R.id.trackName);

            trackIndex.setText(trackInfoListArrayList.get(i).getTrackIndex() + "");
            trackName.setText(trackInfoListArrayList.get(i).getTrackName());


        }
        return view;
    }
}
