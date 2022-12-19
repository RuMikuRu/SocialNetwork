package com.example.Controllers;

import com.example.model.Post;
import com.example.service.postService.PostService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@CrossOrigin
@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {
    @NotNull
    private PostService postService;

    @GetMapping(value = "/all",produces = APPLICATION_JSON_VALUE)
    public List<Post> getAllPost() throws SQLException {
        return postService.findAllUsers();
    }

    @GetMapping("fromKey/{key}")
    public Post getFromKey(@PathVariable int key) throws SQLException {
        return postService.findByKey(key);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Post create(@RequestBody Post request) throws SQLException {
        return postService.createPost(request);
    }

    @PatchMapping(value = "/{postId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Post update(@PathVariable Integer postId, @RequestBody Post request) throws SQLException {
        return postService.updatePost(postId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{postId}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer postId) throws SQLException {
        postService.deletePost(postId);
    }
}
