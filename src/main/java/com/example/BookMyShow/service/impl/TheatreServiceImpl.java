package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.exception.ResourceNotFoundException;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.repository.MovieRepo;
import com.example.BookMyShow.repository.TheatreRepo;
import com.example.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public Theatre createTheatre(Theatre theatre) {
//        Movie movie=this.movieRepo.findById(movie_id)
//                .orElseThrow(()->new ResourceNotFoundException("movie","MovieId",movie_id));
//        Theatre theatre1=new Theatre();
//        theatre1.setCity(theatre.getCity());
//        theatre1.setName(theatre.getName());
//        Set<Movie> movies=new HashSet<>();
//        movies.add(movie);
//        theatre1.setMovies(movies);
//        Theatre newTheatre=this.theatreRepo.save(theatre1);
        return this.theatreRepo.save(theatre);
    }

    @Override
    public List<Theatre> ListAllTheatres(String city) {
        List<Theatre> theatre=this.theatreRepo.findByCity(city)
                .orElseThrow(()->new ResourceNotFoundException("City","cityname",city));
        return theatre;
    }

    @Override
    public List<Theatre> ListAllMoviesInTheatre(String theatre_name) {
        List<Theatre> theatres=this.theatreRepo.findByName(theatre_name)
                .orElseThrow(()->new ResourceNotFoundException("Theatre","TheatreName",theatre_name));
        return theatres;
    }

    @Override
    public List<Theatre> ListTheatres() {
        return this.theatreRepo.findAll();
    }

    @Override
    public Theatre AssignMovieToTheatre(int theatre_id, int movie_id) {
        Set<Movie> movieSet=null;
        Theatre theatre= this.theatreRepo.findById(theatre_id).get();
//                .orElseThrow(()->new ResourceNotFoundException("theatre","TheatreId",theatre_id));
        System.out.println("-------theatre-------"+""+theatre);
        Movie movie=this.movieRepo.findById(movie_id).get();
//                .orElseThrow(()->new ResourceNotFoundException("movie","MovieId",movie_id));
        System.out.println("------MOvie-------"+""+movie);
        movieSet=theatre.getMovies();
        movieSet.add(movie);
        System.out.println("--------------------------"+movieSet);
        theatre.setMovies(movieSet);
        System.out.println("-----------------------+"+this.theatreRepo.save(theatre));
        return this.theatreRepo.save(theatre);
    }
}
