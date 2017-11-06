package com.codeup.blog.models;

public class Post {
    private String title;
    private String body;
    private long id;

    public Post(){

    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, Long id){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
