package com.example.user.the_power_of_music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listContainer;
    PostListAdapter postListAdapter;
    ArrayList<PostItem> postItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fuel.get("https://api.nasa.gov/planetary/apod?api_key=seR6SviZPV6pVgI6Jsj4SlmsA4nBGf23V0vk8XZG").responseString(new Handler<String>() {
            @Override
            public void success(Request request, Response response, String s) {
                Log.d("result: ", s);
            }

            @Override
            public void failure(Request request, Response response, FuelError fuelError) {
                Log.d("error: ", fuelError.toString());
            }
        });

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
