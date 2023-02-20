package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
    Optional<List<Theatre>> findByName(String name);
    Optional<List<Theatre>> findByCity(String city);

}
