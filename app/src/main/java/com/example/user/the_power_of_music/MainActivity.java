package com.example.user.the_power_of_music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listContainer;
    PostListAdapter postListAdapter;
    ArrayList<PostItem> postItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listContainer = (ListView) findViewById(R.id.listContainer);

        postItemArrayList = new ArrayList<>();
        postItemArrayList.add(new PostItem("Album Title!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));
        postItemArrayList.add(new PostItem("Title!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));
        postItemArrayList.add(new PostItem("Album!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));
        postItemArrayList.add(new PostItem("Title!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));
        postItemArrayList.add(new PostItem("Album !!!!!!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));
        postItemArrayList.add(new PostItem("Album Title!", "Content......!!!!", "Artist Name", "2018-08-13", "cover.jpg"));

        postListAdapter = new PostListAdapter(MainActivity.this, postItemArrayList);
        listContainer.setAdapter(postListAdapter);



    }
}
