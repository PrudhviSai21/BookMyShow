package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

    Optional<Movie> findByName(String name);
}
