package com.example.user.the_power_of_music;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;



public class PostActivity extends AppCompatActivity {



    ImageView albumCoverImageView;
    TextView titleTextView;
    TextView artistTextView;
    Intent intent;

    ListView trackInfoContainer;
    TrackInfoAdapter trackInfoAdapter;
    ArrayList<TrackInfo> trackInfoArrayList;

    MediaPlayer player;
    ArrayList<String> trackList;
    Button playButton;
    SeekBar seekBar;

    Handler playHandler;

    int currentSong = 0;



    class PlayerThread extends Thread {
        @Override
        public void run() {
            super.run();
            while(player != null && player.isPlaying()) {
                seekBar.setProgress(player.getCurrentPosition());
                if(seekBar.getProgress() == player.getDuration()) {
                    Log.d("Here!!!!", "jheradsas");
                    player.stop();
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            Message msg = playHandler.obtainMessage();

                            playHandler.sendMessage(msg);
                        }
                    }.start();
                }
            }
        }
    }



    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        intent = getIntent();
        trackList = intent.getStringArrayListExtra("track");




        playHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                playButton.setText("Play");

                if(trackList.size() - 1 > currentSong) {

                    currentSong += 1;

                    seekBar.setProgress(0);
                    player = new MediaPlayer();

                    try {

                        player.setDataSource("http://52.78.31.220/uploads/" + trackList.get(currentSong));
                        player.prepare();
                        seekBar.setMax(player.getDuration());
                        Log.d("duration", player.getDuration() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();

                    new PlayerThread().start();

                    playButton.setText("Pause");
                } else {
                    Log.d("Here", "here!!");
                    currentSong = 0;
                    seekBar.setProgress(0);
                    player = new MediaPlayer();
                    try {

                        player.setDataSource("http://52.78.31.220/uploads/" + trackList.get(currentSong));
                        player.prepare();
                        seekBar.setMax(player.getDuration());
                        Log.d("duration", player.getDuration() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                Log.d("currentSong", currentSong + "");
            }
        };


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if(seekBar.getMax() == i && currentSong == trackList.size() - 1) {
                        player.stop();
                        

                    }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                player.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int seekTime = seekBar.getProgress();
                player.seekTo(seekTime);
                player.start();
                new PlayerThread().start();
            }
        });


        playButton = (Button) findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(player != null && player.isPlaying()) {
                    player.pause();
                    playButton.setText("Play");
                    return;
                } else if(player == null) {
                    seekBar.setProgress(0);
                    player = new MediaPlayer();
                    try {

                        player.setDataSource("http://52.78.31.220/uploads/" + trackList.get(0));
                        player.prepare();
                        seekBar.setMax(player.getDuration());

                        Log.d("duration", player.getDuration() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();

                    new PlayerThread().start();

                    playButton.setText("Pause");

                    return;
                }
                player.start();
                playButton.setText("Pause");


            }
        });




//        player.start();

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        albumCoverImageView = (ImageView) findViewById(R.id.albumCoverImageView);
        artistTextView = (TextView) findViewById(R.id.artistTextView);

        titleTextView.setText(intent.getStringExtra("title"));
        artistTextView.setText("by " + intent.getStringExtra("artist"));
        Picasso.get().load(intent.getStringExtra("cover")).into(albumCoverImageView);

        trackInfoArrayList = new ArrayList<>();
//        Log.d("tag", "array: " + intent.getStringArrayListExtra("name"));
        for(int i = 0;i < intent.getStringArrayListExtra("name").size();i++){
            trackInfoArrayList.add(new TrackInfo(i + 1 + "",
                    intent.getStringArrayListExtra("name").get(i),
                    intent.getStringArrayListExtra("track").get(i)));

        }


        trackInfoContainer = (ListView) findViewById(R.id.trackInfoContainer);
        trackInfoAdapter = new TrackInfoAdapter(PostActivity.this, trackInfoArrayList);
        trackInfoContainer.setAdapter(trackInfoAdapter);
        trackInfoContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(player != null && player.isPlaying()) {
                    player.stop();
                }
                seekBar.setProgress(0);
                player = new MediaPlayer();
                try {
                    player.setDataSource("http://52.78.31.220/uploads/" + trackList.get(i));
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                currentSong = i;
                Log.d("current", currentSong + "");
                player.start();
                new PlayerThread().start();
                seekBar.setMax(player.getDuration());

                playButton.setText("Pause");

                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(player != null && player.isPlaying()) {
                            playButton.setText("Play");
                            player.pause();
                        } else {
                            playButton.setText("Pause");
                            player.start();
                        }
                    }
                });


            }
        });






//        PostActivity.this.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if(player != null && player.isPlaying()){
////                    int currentPosition = player.getCurrentPosition() / 1000;
//                    seekBar.setProgress(player.getCurrentPosition());
//
//                }
//                playHandler.postDelayed(this, 1000);
//            }
//        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.stop();

    }
}
