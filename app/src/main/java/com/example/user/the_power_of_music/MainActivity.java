package com.example.user.the_power_of_music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView listContainer;
    PostListAdapter postListAdapter;
    ArrayList<PostItem> postItemArrayList;

    public class PostItemCallResponse {
        @SerializedName("list")
        List list;
        @SerializedName("title")
        String title;
        @SerializedName("body")
        String body;
        @SerializedName("cover")
        String cover;
        @SerializedName("artist")
        String artist;
        @SerializedName("publishedDate")
        String publishedDate;
        @SerializedName("tags")
        ArrayList<String> tags;


    }

    public class List {
        @SerializedName("name")
        ArrayList<String> name;
        @SerializedName("track")
        ArrayList<String> track;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidNetworking.initialize(getApplicationContext());

        postItemArrayList = new ArrayList<>();


        AndroidNetworking.get("http://52.78.31.220/api/post")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject result = null;
                            PostItemCallResponse postItemCallResponse = null;
                            for(int i = 0;i<response.length();i++){
                                result = (JSONObject) response.getJSONObject(i);
                                postItemCallResponse = new Gson().fromJson(result.toString(), PostItemCallResponse.class);
                                postItemArrayList.add(new PostItem(postItemCallResponse.list.name,
                                                                    postItemCallResponse.list.track,
                                                                    postItemCallResponse.title,
                                        postItemCallResponse.body,
                                        postItemCallResponse.artist,
                                        postItemCallResponse.publishedDate,
                                        "http://52.78.31.220/uploads/" + postItemCallResponse.cover,
                                        postItemCallResponse.tags));

                            }
                            listContainer = (ListView) findViewById(R.id.listContainer);
                            postListAdapter = new PostListAdapter(MainActivity.this, postItemArrayList);
                            listContainer.setAdapter(postListAdapter);
                            listContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent playerViewIntent = new Intent(MainActivity.this, PostActivity.class);
                                    playerViewIntent.putExtra("title", postItemArrayList.get(i).getTitle());
                                    playerViewIntent.putExtra("cover", postItemArrayList.get(i).getCover());
                                    playerViewIntent.putExtra("artist", postItemArrayList.get(i).getArtist());
                                    playerViewIntent.putExtra("name", postItemArrayList.get(i).getName());
                                    playerViewIntent.putExtra("track", postItemArrayList.get(i).getTrack());
                                    Log.d("asdasdasd", postItemArrayList.get(i).getTrack() + "");
                                    MainActivity.this.startActivity(playerViewIntent);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });




    }

}
