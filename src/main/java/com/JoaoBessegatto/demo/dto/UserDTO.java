package com.JoaoBessegatto.demo.dto;

import com.JoaoBessegatto.demo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO (User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

}
