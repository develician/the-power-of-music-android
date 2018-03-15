package com.example.user.the_power_of_music;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by USER on 2018-03-13.
 */

public class PostListAdapter extends BaseAdapter {

    Context context;
    ArrayList<PostItem> postItemArrayList;

    ImageView coverImage;
    TextView albumTitle;
    TextView artist;
    TextView publishedDate;
    TextView body;

    public PostListAdapter(Context context, ArrayList<PostItem> postItemArrayList) {
        this.context = context;
        this.postItemArrayList = postItemArrayList;
    }

    @Override
    public int getCount() {
        return this.postItemArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.postItemArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.post_item, null);
            coverImage = (ImageView) view.findViewById(R.id.coverImage);
            albumTitle = (TextView) view.findViewById(R.id.albumTitle);
            artist = (TextView) view.findViewById(R.id.artist);
            publishedDate = (TextView) view.findViewById(R.id.publishedDate);
            body = (TextView) view.findViewById(R.id.body);


//            coverImage.setImageURI();
            Picasso.get().load(postItemArrayList.get(i).getCover()).into(coverImage);
            albumTitle.setText(postItemArrayList.get(i).getTitle());
            artist.setText(postItemArrayList.get(i).getArtist());
            publishedDate.setText(postItemArrayList.get(i).getPublishedDate());
            body.setText(postItemArrayList.get(i).getBody());

        }
        return view;
    }
}
