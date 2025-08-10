package com.JoaoBessegatto.demo.services;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO>findAll(){
        List<User> user = userRepository.findAll();
        return user.stream()
                .map(UserDTO::new)
                .toList();
    }
   public Optional<User>findById(String id){
        return userRepository.findById(id);
   }
}
