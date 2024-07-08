package com.api.cinema.persistence.repository;

import com.api.cinema.persistence.documents.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MovieCriteriaRepositoryImpl implements MovieCriteriaRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<Movie> findByCapacity(Integer movieCapacity) {
        Query query = new Query();
        query.addCriteria(Criteria.where("movieCapacity").is(movieCapacity));
        return mongoTemplate.find(query, Movie.class);
    }
}
