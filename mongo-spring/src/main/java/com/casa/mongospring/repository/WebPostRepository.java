package com.casa.mongospring.repository;

import com.casa.mongospring.model.WebPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WebPostRepository extends MongoRepository<WebPost, String> {
    List<WebPost> findByTitleContaining(String text);

    @Query("{ $and: [ {date: {$gte: ?1}}, {date: {$lte: ?2}}, { $or: [{'title': { $regex: ?0, $options: 'i'}}, {'body': { $regex: ?0, $options: 'i'}}, {'comments.text': { $regex: ?0, $options: 'i'}}]}]}")
    List<WebPost> fullSearch(String text, Date from, Date to);
}
