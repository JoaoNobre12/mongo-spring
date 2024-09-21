package com.casa.mongospring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "user")
public class User implements Serializable {


    @EqualsAndHashCode.Include
    @Id
    private String id;
    @EqualsAndHashCode.Include
    private String name;
    private String email;
}
