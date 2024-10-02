package com.casa.mongospring.model;

import com.casa.mongospring.dto.AuthorDTO;
import com.casa.mongospring.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Document
public class WebPost implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String title;
    private Date date;
    private String body;
    private AuthorDTO author;
    @Setter(AccessLevel.NONE)
    private List<CommentDTO> comments = new ArrayList<>();

    public WebPost(String id, String title, Date date, String body, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.body = body;
        this.author = author;
    }
}
