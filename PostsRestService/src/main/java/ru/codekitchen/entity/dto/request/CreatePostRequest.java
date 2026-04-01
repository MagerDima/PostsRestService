package ru.codekitchen.entity.dto.request;

import ru.codekitchen.entity.Post;

import java.time.LocalDateTime;

public class CreatePostRequest {
    private final String author;
    private final String title;

    public CreatePostRequest(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Post toEnity() {
        return new Post(
                author,
                LocalDateTime.now(),
                0,
                0,
                title
        );
    }
}
