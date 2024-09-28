package com.casa.mongospring.dto;

import com.casa.mongospring.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

    public AuthorDTO(User user) {
        this.name = user.getName();
        this.id = user.getId();
    }
}
