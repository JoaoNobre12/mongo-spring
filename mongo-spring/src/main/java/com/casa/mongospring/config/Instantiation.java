package com.casa.mongospring.config;

import com.casa.mongospring.model.User;
import com.casa.mongospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null, "Maria Brown", "maria@beo.com");
        User user2 = new User(null, "Alex Green", "alex@beo.com");
        User user3 = new User(null, "Bob Grey", "bob@beo.com");

        userRepository.saveAll(List.of(user1, user2, user3));
    }
}
