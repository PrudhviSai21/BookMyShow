package com.example.BookMyShow.controller;

import com.example.BookMyShow.config.ApiResponse;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/createmovie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie movie1=this.movieService.createMovie(movie);
        return new ResponseEntity<>(movie1, HttpStatus.CREATED);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies=this.movieService.AllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @PutMapping("/updatemovie/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie,@PathVariable int id){
        Movie updatemovie=this.movieService.updateMovie(movie,id);
        return new ResponseEntity<>(updatemovie,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie=this.movieService.findMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable int id){
        this.movieService.deleteMovieById(id);
        return new ResponseEntity<>(new ApiResponse("Movie Deleted Successfully",true),HttpStatus.OK);
    }
}
