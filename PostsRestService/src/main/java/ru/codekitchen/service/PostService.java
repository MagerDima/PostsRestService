package ru.codekitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.codekitchen.PostsRestServiceApplication;
import ru.codekitchen.entity.Post;
import ru.codekitchen.entity.dto.PostDto;
import ru.codekitchen.entity.dto.PostsContainerDto;
import ru.codekitchen.entity.dto.request.CreatePostRequest;
import ru.codekitchen.entity.dto.request.UpdatePostRequest;
import ru.codekitchen.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostsContainerDto findAll() {
        List<PostDto> posts = postRepository.findAll().stream()
                .map(Post::toDto)
                .collect(Collectors.toList());
        return new PostsContainerDto(posts);
    }

    public PostDto findById(int id) {
        return postRepository.findById(id)
                .map(Post::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " not found"));
    }

    public PostDto save(CreatePostRequest request) {
        Post post = request.toEnity();
        return postRepository.save(post).toDto();
    }

    public PostDto update(int id, UpdatePostRequest request) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    Post updatePost = request.toEntity(existingPost.getId(), existingPost.getCreationDate());
                    return postRepository.save(updatePost).toDto();
                })
                .orElseThrow(() -> new IllegalArgumentException("Post with id = " + id + " not found"));
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }
}
