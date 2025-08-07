package com.cinesage.movie_service.mapper;

import com.cinesage.movie_service.dto.MovieResponseDTO;
import com.cinesage.movie_service.entity.Movie;

public class MovieMapper {

   public static MovieResponseDTO toDTO(Movie movie){
      if(movie == null) return null;

      return new MovieResponseDTO(movie.getMovieName(), movie.getYear(), movie.getGenre());
   }
}
