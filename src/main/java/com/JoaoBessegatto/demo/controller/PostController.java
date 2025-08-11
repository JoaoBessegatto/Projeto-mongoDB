package com.JoaoBessegatto.demo.controller;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.Post;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
import com.JoaoBessegatto.demo.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
        return ResponseEntity.ok().body(post);
    }
}
