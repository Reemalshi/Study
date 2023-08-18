package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class PostAdpter extends BaseAdapter {
    private Context context;
    private List<Post> posts;

    public PostAdpter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }
    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_post, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView contentTextView = convertView.findViewById(R.id.contentTextView);
        ImageView postImageView = convertView.findViewById(R.id.postImageView);

        Post post = (Post) getItem(position);

        titleTextView.setText(post.getTitle());
        contentTextView.setText(post.getContent());
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Bitmap bitmap = null;
                    bitmap = BitmapFactory.decodeStream((InputStream)new URL(post.getImage()).getContent());
                    postImageView.setImageBitmap(bitmap);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();


        return convertView;
    }
}