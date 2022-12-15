package com.example.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post{
    private int id;

    private String title;

    private String content;

    private String postCreatedDate;

    public Post(int id, String title, String content, String postCreatedDate)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postCreatedDate = postCreatedDate;
    }
}
