package com.example.service.postService;

import com.example.handlers.TableFastQuery;
import com.example.model.Post;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.handlers.Configs.connectFromDB;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> findAllUsers() throws SQLException {
        List<Post> posts = new ArrayList<>();
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.getALL("posts","id_post","content","post_created_date","title"));
        while(rsmd.next())
        {
            int id = rsmd.getInt(1);
            String title = rsmd.getString(4);
            String content = rsmd.getString(2);
            String date = rsmd.getString(3);
            Post post = new Post(id,title,content,date);
            posts.add(post);
        }
        rsmd.close();
        return posts;
    }

    @Override
    public Post findByKey(int key) throws SQLException {
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.getFromKey("posts","id_post", String.valueOf(key)));
        if(rsmd.next()) {
            int id = rsmd.getInt(1);
            String title = rsmd.getString(4);
            String content = rsmd.getString(2);
            String date = rsmd.getString(3);
            Post post = new Post(id, title, content, date);
            rsmd.close();
            return post;
        }
        else {rsmd.close();
            return null;}
    }

    @Override
    public Post createPost(@NotNull Post request) throws SQLException {
        ResultSet rsmd = connectFromDB().executeQuery(TableFastQuery.addData("posts","id_post","content",
                "post_created_date","title",request.getId(),request.getContent(),request.getPostCreatedDate(),request.getTitle()));
        if(rsmd.next()) {
            rsmd.close();
            return new Post(request.getId(), request.getContent(), request.getPostCreatedDate(), request.getTitle());
        }
        else {
            rsmd.close();
            return null;
        }
    }

    @Override
    public Post updatePost(Integer postId, @NotNull Post request) throws SQLException {
        ResultSet rsmd= connectFromDB().executeQuery(TableFastQuery.updateData("posts","content","post_created_date",
                "title",request.getContent(),request.getPostCreatedDate(),request.getTitle(),"id_post",postId));
        if(rsmd.next())
        {
            rsmd.close();
            return request;
        }
        else
        {
            rsmd.close();
            return null;
        }
    }

    @Override
    public void deletePost(Integer postId) throws SQLException {
        boolean rsmd = connectFromDB().executeQuery(TableFastQuery.deleteData("posts","id_post",postId)).next();
    }


}
