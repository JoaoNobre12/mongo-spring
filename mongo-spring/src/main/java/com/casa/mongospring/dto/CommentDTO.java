package com.casa.mongospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Date date;
    private String comment;
    private AuthorDTO author;
}
