package com.example.BookMyShow.controller;

import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/createtheatre")
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre){

        Theatre theatre1=this.theatreService.createTheatre(theatre);
        return new ResponseEntity<>(theatre1, HttpStatus.CREATED);
    }

    @GetMapping("/theatres/{city}")
    public ResponseEntity<List<Theatre>> ListAllTheatres(@PathVariable String city){
        List<Theatre> theatres=this.theatreService.ListAllTheatres(city);
        return new ResponseEntity<>(theatres,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Theatre>> ListAllTheatresByName(@RequestParam(value="theatre_name") String theatre_name){
        List<Theatre> theatres=this.theatreService.ListAllMoviesInTheatre(theatre_name);
        return new ResponseEntity<>(theatres,HttpStatus.OK);
    }

    @GetMapping("/theatres")
    public ResponseEntity<List<Theatre>>listTheatres(){
        List<Theatre> theatre=this.theatreService.ListTheatres();
        return new ResponseEntity<>(theatre,HttpStatus.OK);
    }

    @PutMapping("/{theatre_id}/Movie/{movie_id}")
    public Theatre updateMoviesinTheatre(@PathVariable int theatre_id,@PathVariable int movie_id){
        Theatre theatre=this.theatreService.AssignMovieToTheatre(theatre_id,movie_id);
        return theatre;
    }
}
