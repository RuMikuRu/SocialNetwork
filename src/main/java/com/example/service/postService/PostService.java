package com.example.service.postService;

import com.example.model.Post;

import java.sql.SQLException;
import java.util.List;

public interface PostService {
    List<Post> findAllUsers() throws SQLException;

    Post findByKey(int key) throws SQLException;

    Post createPost(Post request) throws SQLException;

    Post updatePost(Integer postId, Post request) throws SQLException;

    void deletePost(Integer postId) throws SQLException;
}
