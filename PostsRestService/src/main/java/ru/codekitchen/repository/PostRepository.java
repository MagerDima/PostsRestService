package ru.codekitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codekitchen.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
