package com.casa.mongospring.dto;

import com.casa.mongospring.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.id = user.getId();
    }
}
