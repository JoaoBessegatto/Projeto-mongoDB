package com.JoaoBessegatto.demo.repository;

import com.JoaoBessegatto.demo.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
