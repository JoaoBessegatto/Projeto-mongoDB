package com.JoaoBessegatto.demo.services;

import com.JoaoBessegatto.demo.dto.UserDTO;
import com.JoaoBessegatto.demo.entities.User;
import com.JoaoBessegatto.demo.exceptions.ObjectNotFoundException;
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
    public User insert(User user){
        return userRepository.save(user);
    }
    public boolean delete(String id){
      if(!userRepository.existsById(id)){
          return false;
      }
      userRepository.deleteById(id);
      return true;
    }
    public User update(User user){
        User newUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
    }
}
