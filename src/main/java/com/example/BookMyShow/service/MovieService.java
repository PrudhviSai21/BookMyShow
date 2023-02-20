package com.example.BookMyShow.service;

import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.User;


import java.util.List;

public interface MovieService {

    List<Movie> AllMovies();
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie user, int id);
    Movie findMovieByName(String name);
    void deleteMovieById(int id);

}
