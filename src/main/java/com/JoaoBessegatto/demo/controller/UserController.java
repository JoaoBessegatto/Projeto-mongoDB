package com.JoaoBessegatto.demo.controller;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.Post;
import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
import com.JoaoBessegatto.demo.services.UserService;
import jakarta.servlet.Servlet;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.ServerSocket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDTO>>findAll(){
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO>findById(@PathVariable String id){
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(new UserDTO(user)))
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    @GetMapping("{id}/posts")
    public ResponseEntity<List<Post>>findPost(@PathVariable String id){
       Optional<User> user = userService.findById(id);
       return ResponseEntity.ok().body(user.get().getPosts());
    }
    @PostMapping()
    public ResponseEntity<Void>insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable String id){
        boolean deletado = userService.delete(id);
        return deletado ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Void>update(@RequestBody UserDTO dto, @PathVariable String id){
        User user = userService.fromDTO(dto);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();

    }
}
