package com.example.BookMyShow.service;

import com.example.BookMyShow.model.Theatre;

import java.util.List;
import java.util.stream.StreamSupport;

public interface TheatreService {

    Theatre createTheatre(Theatre theatre);
    List<Theatre> ListAllTheatres(String city);
    List<Theatre> ListAllMoviesInTheatre(String theatre_name);

    List<Theatre> ListTheatres();

    Theatre AssignMovieToTheatre(int theatre_id,int movie_id);
}
