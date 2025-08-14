package com.JoaoBessegatto.demo.controller;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.Post;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
import com.JoaoBessegatto.demo.services.PostService;
import com.JoaoBessegatto.demo.util.URL;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
