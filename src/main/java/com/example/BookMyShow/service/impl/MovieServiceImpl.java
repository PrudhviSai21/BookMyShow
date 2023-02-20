package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.exception.ResourceNotFoundException;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.repository.MovieRepo;
import com.example.BookMyShow.repository.TheatreRepo;
import com.example.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheatreRepo theatreRepo;
    @Override
    public List<Movie> AllMovies() {
        return this.movieRepo.findAll();
    }

    @Override
    public Movie createMovie(Movie movie) {
//        Theatre theatre =this.theatreRepo.findById(id)
//                .orElseThrow(()->new ResourceNotFoundException("Theatre","TheatreId",id));
//        Set<Theatre> theatres=new HashSet<>();
//        theatres.add(theatre);
//        Movie movie1=new Movie();
////        movie1.setTheatres(theatres);
//        movie1.setName(movie.getName());
//        movie1.setLanguage(movie.getLanguage());
//        movie1.setDuration(movie.getDuration());
//        movie1.setRelease_Date(movie.getRelease_Date());
        return this.movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie, int id) {
        Movie newmovie=this.movieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movie","movie_id",id));

        if(movie.getName()!=null)
            newmovie.setName(movie.getName());
        if(movie.getDuration()!=null)
            newmovie.setDuration(movie.getDuration());
        if(movie.getLanguage()!=null)
            newmovie.setLanguage(movie.getLanguage());
        if(movie.getRelease_Date()!=null)
            newmovie.setRelease_Date(movie.getRelease_Date());

        return this.movieRepo.save(newmovie);
    }

    @Override
    public Movie findMovieByName(String name) {
        Movie movie=this.movieRepo.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("Movie","MovieName",name));
        return movie;
    }

    @Override
    public void deleteMovieById(int id) {
        Movie movie=this.movieRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movie","movieId",id));
        this.movieRepo.delete(movie);
    }
}
