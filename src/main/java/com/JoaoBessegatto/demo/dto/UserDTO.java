package com.JoaoBessegatto.demo.dto;

import com.JoaoBessegatto.demo.entities.Post;
import com.JoaoBessegatto.demo.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post>posts = new ArrayList<>();

    public UserDTO (User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
