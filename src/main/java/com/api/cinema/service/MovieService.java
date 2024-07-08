package com.api.cinema.service;

import com.api.cinema.persistence.documents.Movie;
import com.api.cinema.persistence.repository.MovieCriteriaRepository;
import com.api.cinema.persistence.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repo;

    @Autowired
    private MovieCriteriaRepository repoCriteria;

    public List<Movie> findAll() {
        return this.repo.findAll();
    }

    public List<Movie> findByName(String name) {
        return this.repo.findByName(name);
    }

    public List<Movie> findByCapacity(Integer movieCapacity){
        return this.repoCriteria.findByCapacity(movieCapacity);
    }
    @Transactional
    public void deleteById(String id) {
        this.repo.deleteById(id);
    }
    @Transactional
    public void insert(Movie movie) {
        this.repo.insert(movie);
    }
}
