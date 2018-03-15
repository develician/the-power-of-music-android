package com.example.user.the_power_of_music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    ImageView albumCoverImageView;
    TextView titleTextView;
    TextView artistTextView;
    Intent intent;

    ListView trackInfoContainer;
    TrackInfoListAdapter trackInfoListAdapter;
    ArrayList<TrackInfoList> trackInfoListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        int index = 0;

        intent = getIntent();

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        albumCoverImageView = (ImageView) findViewById(R.id.albumCoverImageView);
        artistTextView = (TextView) findViewById(R.id.artistTextView);

        titleTextView.setText(intent.getStringExtra("title"));
        artistTextView.setText("by " + intent.getStringExtra("artist"));
        Picasso.get().load(intent.getStringExtra("cover")).into(albumCoverImageView);

        trackInfoListArrayList = new ArrayList<>();
//        Log.d("tag", "array: " + intent.getStringArrayListExtra("name"));
        for(int i = 0;i < intent.getStringArrayListExtra("name").size();i++){
            trackInfoListArrayList.add(new TrackInfoList(i + 1, intent.getStringArrayListExtra("name").get(i)));
        }

        trackInfoContainer = (ListView) findViewById(R.id.trackInfoContainer);
        trackInfoListAdapter = new TrackInfoListAdapter(PostActivity.this, trackInfoListArrayList);
        trackInfoContainer.setAdapter(trackInfoListAdapter);


    }
}
