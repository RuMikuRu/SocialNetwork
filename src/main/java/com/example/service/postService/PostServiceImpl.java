package com.example.service.postService;

import com.example.handlers.TableFastQuery;
import com.example.model.Post;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.handlers.Configs.conectFromDB;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> findAllUsers() throws SQLException {
        List<Post> posts = new ArrayList<>();
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.getALL("posts","id_post","content","post_create_date","title"));
        while(rsmd.next())
        {
            int id = rsmd.getInt(1);
            String title = rsmd.getString(4);
            String content = rsmd.getString(2);
            String date = rsmd.getString(3);
            Post post = new Post(id,title,content,date);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Post findByKey(int key) throws SQLException {
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.getFromKey("posts","id_post", String.valueOf(key)));
        if(rsmd.next()) {
            int id = rsmd.getInt(1);
            String title = rsmd.getString(4);
            String content = rsmd.getString(2);
            String date = rsmd.getString(3);
            Post post = new Post(id, title, content, date);
            return post;
        }
        else {return null;}
    }

    @Override
    public Post createPost(Post request) throws SQLException {
        ResultSet rsmd = conectFromDB().executeQuery(TableFastQuery.addData("posts","id_post","content",
                "post_create_date","title",request.getId(),request.getContent(),request.getPostCreatedDate(),request.getTitle()));
        if(rsmd.next()) {
            return new Post(request.getId(), request.getContent(), request.getPostCreatedDate(), request.getTitle());
        }
        else {
            return null;
        }
    }

    @Override
    public Post updatePost(Integer postId, Post request) throws SQLException {
        ResultSet rsmd= conectFromDB().executeQuery(TableFastQuery.updateData("posts","content","post_create_date",
                "title",request.getContent(),request.getPostCreatedDate(),request.getTitle(),"id_post",postId));
        if(rsmd.next())
        {
            return request;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void deletePost(Integer postId) throws SQLException {
        boolean rsmd = conectFromDB().executeQuery(TableFastQuery.deleteData("posts","id_post",postId)).next();
    }


}
