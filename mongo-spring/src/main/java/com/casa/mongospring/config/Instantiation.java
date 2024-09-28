package com.casa.mongospring.config;

import com.casa.mongospring.dto.AuthorDTO;
import com.casa.mongospring.model.User;
import com.casa.mongospring.model.WebPost;
import com.casa.mongospring.repository.UserRepository;
import com.casa.mongospring.repository.WebPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final WebPostRepository webPostRepository;

    @Autowired
    public Instantiation(UserRepository userRepository, WebPostRepository webPostRepository) {
        this.userRepository = userRepository;
        this.webPostRepository = webPostRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        webPostRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC-3"));

        User user1 = new User(null, "Maria Brown", "maria@beo.com");
        User user2 = new User(null, "Alex Green", "alex@beo.com");
        User user3 = new User(null, "Bob Grey", "bob@beo.com");

        userRepository.saveAll(List.of(user1, user2, user3));

        WebPost post1 = new WebPost(
                null, "Spring Boot Guide", sdf.parse("21/03/2018"),
                "otimo guia para iniciantes", new AuthorDTO(user1));
        WebPost post2 = new WebPost(
                null, "MongoDB Tips", sdf.parse("21/06/2015"),
                "otimo guia para iniciantes aprender mongo", new AuthorDTO(user2));
        WebPost post3 = new WebPost(
                null, "Java Best Practices", sdf.parse("13/05/2023"),
                "otimo guia para iniciantes aprender java", new AuthorDTO(user1));

        webPostRepository.saveAll(List.of(post1, post2, post3));

        user1.getPosts().addAll(List.of(post1, post3));

        userRepository.save(user1);
    }
}
