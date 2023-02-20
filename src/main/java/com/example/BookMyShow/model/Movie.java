package com.example.BookMyShow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movie_id;
    private String name;
    private String Duration;
    private String Language;
    @JsonFormat(pattern = "dd-MM-yyy")
    @Column(name = "release_date")
    private Date Release_Date;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "movies")
    private Set<Theatre> theatres=new HashSet<>();



}
