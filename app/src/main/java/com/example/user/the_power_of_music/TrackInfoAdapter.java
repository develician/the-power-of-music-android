package com.example.user.the_power_of_music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by paul on 2018. 3. 18..
 */

public class TrackInfoAdapter extends BaseAdapter {
    Context context;
    ArrayList<TrackInfo> trackInfoArrayList;

    TextView trackName;
    TextView trackIndex;

    public TrackInfoAdapter(Context context, ArrayList<TrackInfo> trackInfoArrayList) {
        this.context = context;
        this.trackInfoArrayList = trackInfoArrayList;
    }

    @Override
    public int getCount() {
        return this.trackInfoArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.trackInfoArrayList.get(i);
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

            trackIndex.setText(trackInfoArrayList.get(i).getIndex());
            trackName.setText(trackInfoArrayList.get(i).getTrackName());


        }
        return view;
    }
}
