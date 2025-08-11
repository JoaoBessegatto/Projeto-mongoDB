package com.JoaoBessegatto.demo.entities;

import com.JoaoBessegatto.demo.dto.AuthorDTO;
import com.JoaoBessegatto.demo.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


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

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date data, String title, String body, AuthorDTO author) {
        this.id = id;
        this.data = data;
        this.title = title;
        this.body = body;
        this.author = author;
    }

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
