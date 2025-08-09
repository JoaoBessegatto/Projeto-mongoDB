package com.JoaoBessegatto.demo.services;

import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User>findAll(){
        return userRepository.findAll();
    }
}
