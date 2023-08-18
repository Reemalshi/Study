package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView postListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postListView = findViewById(R.id.postListView);

        List<Post> posts = generateSamplePosts();
        PostAdpter adapter = new PostAdpter(this, posts);
        postListView.setAdapter(adapter);
    }



    private List<Post> generateSamplePosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "This is the content of post 1.","https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8fDA%3D&w=1000&q=80"));
        posts.add(new Post("Post 2", "This is the content of post 2.","https://images.unsplash.com/photo-1520967782066-e09c18e5d1b6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDZ8fHxlbnwwfHx8fHw%3D&w=1000&q=80"));
        posts.add(new Post("Post 3", "This is the content of post 3.","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiZqpz3qEWa45svv51uex_BuUwdz6w_RNq3lzP6UWTZ26tV7crUqBNnKJIdTbmmAWMIIs&usqp=CAU"));
        // Add more posts here
        return posts;
    }
}