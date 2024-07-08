package com.api.cinema.controller;

import com.api.cinema.persistence.documents.Movie;
import com.api.cinema.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(tags = "movie", description = "movie")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<Object> get(){
        List<Movie> movies = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/filter/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable(value = "name")  String name){
        List<Movie> movies = service.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }
    @GetMapping("/filter/capacity")
    public ResponseEntity<Object> getByCapacity(@RequestParam(value = "movieCapacity") Integer movieCapacity){
        List<Movie> movies = service.findByCapacity(movieCapacity);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Movie movie){
        this.service.insert(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") String id){
        this.service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Movie deleted successfully.");
    }

}
