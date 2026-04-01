package ru.codekitchen.conntroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.codekitchen.entity.Post;
import ru.codekitchen.entity.dto.PostDto;
import ru.codekitchen.entity.dto.PostsContainerDto;
import ru.codekitchen.entity.dto.request.CreatePostRequest;
import ru.codekitchen.entity.dto.request.UpdatePostRequest;
import ru.codekitchen.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public PostsContainerDto findAll() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public PostDto findById(@PathVariable int id) {
        return postService.findById(id);
    }

    @PostMapping("/posts")
    public PostDto save(@RequestBody CreatePostRequest request) {
        return postService.save(request);
    }

    @PutMapping("/posts/{id}")
    public PostDto update(@PathVariable int id, @RequestBody UpdatePostRequest request) {
        return postService.update(id, request);
    }

    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }
}
