package com.api.cinema.persistence.repository;

import com.api.cinema.persistence.documents.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query("{'movieName' : {$regex : ?0, $options: 'i'}}")
    List<Movie> findByName(String name);

    List<Movie> findByMovieName(String movieName);

}