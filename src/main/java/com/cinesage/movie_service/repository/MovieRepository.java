package com.cinesage.movie_service.repository;

import com.cinesage.movie_service.dto.MovieResponseDTO;
import com.cinesage.movie_service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

   @Query("select m from Movie m where lower(m.movieName) like lower(concat('%', :searchTerm, '%'))")
   List<Movie> searchMovie(String searchTerm);

   List<Movie> findByYear(int year);

}
