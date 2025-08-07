package com.cinesage.movie_service.controller;

import com.cinesage.movie_service.dto.MovieResponseDTO;
import com.cinesage.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

   private MovieService movieService;

   @Autowired
   public MovieController(MovieService movieService){
      this.movieService = movieService;
   }

   @PostMapping("/addMovie")
   public ResponseEntity<String> addMovie(@RequestBody MovieResponseDTO movieResponseDTO){
      return ResponseEntity.ok(movieService.addMovie(movieResponseDTO));
   }

   @GetMapping("/getMovie/{movieId}")
   public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long movieId){
      return ResponseEntity.ok(movieService.getMovie(movieId));
   }

   @GetMapping("/getAllMovies")
   public ResponseEntity<Page<MovieResponseDTO>> getAllMovies(Pageable pageable){
      return ResponseEntity.ok(movieService.getAllMovies(pageable));
   }

   @GetMapping("/searchMovie/{searchTerm}")
   public ResponseEntity<Page<MovieResponseDTO>> searchMovie(@PathVariable String searchTerm, Pageable pageable){
      return ResponseEntity.ok(movieService.searchMovie(searchTerm, pageable));
   }

   @GetMapping("/getMoviesByYear/{year}")
   public ResponseEntity<Page<MovieResponseDTO>> getMoviesByYear(@PathVariable int year, Pageable pageable){
      return ResponseEntity.ok(movieService.getMoviesByYear(year, pageable));
   }

}
