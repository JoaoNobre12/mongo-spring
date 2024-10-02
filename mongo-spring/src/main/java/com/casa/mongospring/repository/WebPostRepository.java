package com.casa.mongospring.repository;

import com.casa.mongospring.model.WebPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebPostRepository extends MongoRepository<WebPost, String> {
    List<WebPost> findByTitleContaining(String text);
}
