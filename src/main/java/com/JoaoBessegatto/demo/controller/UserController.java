package com.JoaoBessegatto.demo.controller;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
import com.JoaoBessegatto.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

}
