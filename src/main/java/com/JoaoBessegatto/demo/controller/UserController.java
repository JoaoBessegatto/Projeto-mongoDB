package com.JoaoBessegatto.demo.controller;

import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<User>>findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
