package com.example.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post implements SocialObject{
    private int id;

    private String title;

    private String content;

    private Date postCreatedDate;

    public Post(int id, String title, String content, Date postCreatedDate)
    {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postCreatedDate = postCreatedDate;
    }

    @Override
    public Object getObject() {
        Post post = new Post(this.id,this.title,this.content, this.postCreatedDate);
        return post;
    }
}
