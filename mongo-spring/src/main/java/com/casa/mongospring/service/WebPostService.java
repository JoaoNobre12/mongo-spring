package com.casa.mongospring.service;

import com.casa.mongospring.model.WebPost;
import com.casa.mongospring.repository.WebPostRepository;
import com.casa.mongospring.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebPostService {

    private final WebPostRepository webPostRepository;

    @Autowired
    public WebPostService(WebPostRepository webPostRepository) {
        this.webPostRepository = webPostRepository;
    }

    public List<WebPost> findAllPosts() {
        return webPostRepository.findAll();
    }

    public WebPost findPostById(String id) {
        return webPostRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Post not found", id)
        );
    }

    public WebPost createPost(WebPost webPost) {
        return webPostRepository.insert(webPost);
    }

    public void deletePost(String id) {
        webPostRepository.deleteById(id);
    }

    public List<WebPost> findPostsByTitleContaining(String title) {
        return webPostRepository.findByTitleContaining(title);
    }
}
