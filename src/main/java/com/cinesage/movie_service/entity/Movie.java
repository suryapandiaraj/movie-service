package com.cinesage.movie_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long movieId;

   @Column(nullable = false)
   private String movieName;

   @Column
   private int year;

   @Column
   private String genre;

   public Movie(String movieName, int year, String genre) {
      this.movieName = movieName;
      this.year = year;
      this.genre = genre;
   }

}
