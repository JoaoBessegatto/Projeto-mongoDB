package com.JoaoBessegatto.demo.repository;

import com.JoaoBessegatto.demo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
