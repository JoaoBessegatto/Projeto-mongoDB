package com.JoaoBessegatto.demo.entities;

import com.JoaoBessegatto.demo.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date data;
    private String title;
    private String body;
    private AuthorDTO author;

    public void fromPost(Post post){
        this.id = post.id;
        this.data = post.data;
        this.title = post.title;
        this.body = post.body;
        this.author = post.author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
