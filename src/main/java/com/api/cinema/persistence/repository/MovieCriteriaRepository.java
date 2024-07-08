package com.api.cinema.persistence.repository;

import com.api.cinema.persistence.documents.Movie;

import java.util.List;

public interface MovieCriteriaRepository {

    List<Movie> findByCapacity(Integer movieCapacity);

}