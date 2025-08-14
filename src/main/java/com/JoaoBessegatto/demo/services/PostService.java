package com.JoaoBessegatto.demo.services;

import com.JoaoBessegatto.demo.entities.Post;
import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
import com.JoaoBessegatto.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;

    public Optional<Post> findById(String id){
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()){
            throw new ObjectNotFoundException("Post não encontrado");
        }
        return post;
    }
    public List<Post>findByTitle(String text){
        return postRepository.findByTitle(text);
    }
    public List<Post>fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }
}
