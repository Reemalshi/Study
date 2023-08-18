package com.example.myapplication;

public class Post {
    private String title;
    private String content;
    private String image;
    private String toolbar;

    public Post(String title, String content,String image) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.toolbar= toolbar;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public String getImage() {
        return image;
    }
    public String getToolbar(){
        return toolbar;
    }
}