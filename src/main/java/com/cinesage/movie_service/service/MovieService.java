package com.cinesage.movie_service.service;

import com.cinesage.movie_service.dto.MovieResponseDTO;
import com.cinesage.movie_service.entity.Movie;
import com.cinesage.movie_service.exception.MovieNotFoundException;
import com.cinesage.movie_service.mapper.MovieMapper;
import com.cinesage.movie_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

   @Autowired
   private MovieRepository movieRepository;

   public MovieResponseDTO getMovie(Long movieId) {
      return
              movieRepository.findById(movieId)
                      .map(MovieMapper::toDTO)
                      .orElseThrow(() -> new MovieNotFoundException("Movie not found!"));
   }

   public String addMovie(MovieResponseDTO movieResponseDTO) {
      Movie movie = new Movie(
              movieResponseDTO.getMovieName(),
              movieResponseDTO.getYear(),
              movieResponseDTO.getGenre()
      );
      movieRepository.save(movie);
      return "Movie saved!";
   }

   public Page<MovieResponseDTO> getAllMovies(Pageable pageable){
      return new PageImpl<>(
              movieRepository.findAll()
                      .stream()
                      .map(MovieMapper::toDTO)
                      .toList(), pageable, movieRepository.count()
      );
   }

   public Page<MovieResponseDTO> searchMovie(String searchTerm, Pageable pageable) {
      return new PageImpl<>(
              movieRepository.searchMovie(searchTerm)
                      .stream()
                      .map(MovieMapper::toDTO)
                      .toList(), pageable, movieRepository.count()
      );
   }

   public Page<MovieResponseDTO> getMoviesByYear(int year, Pageable pageable) {
      return new PageImpl<>(
              movieRepository.findByYear(year)
                      .stream()
                      .map(MovieMapper::toDTO)
                      .toList(), pageable, movieRepository.count()
      );
   }

}
