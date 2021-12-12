package com.example.spring_course.service;

import com.example.spring_course.entity.Movie;
import com.example.spring_course.entity.Review;
import com.example.spring_course.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {
  private static final Logger log = LoggerFactory.getLogger(MovieService.class);

  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie addMovie(Movie movie) {
    movie.setRating(null);
    movie.setCreatedTimestamp(new Date());
    return save(movie);
  }

  public Movie getMovie(Long movieId) {
    Optional<Movie> opMovie = movieRepository.findById(movieId);
    if (opMovie.isEmpty())
      throw new EntityNotFoundException("Movie with id " + movieId + " not found");
    return opMovie.get();
  }

  public Movie save(Movie movie) {
    movie.setLastUpdateTimestamp(new Date());
    log.info("Saving movie with ID: ''{}''", movie.getId());
    return movieRepository.save(movie);
  }

  public void updateRating(Long movieId) {
    Movie movie = getMovie(movieId);
    // TODO: remake to do it by SQL query
    List<Float> ratingList = movie.getReviews().stream().map(Review::getMovieRating).collect(Collectors.toList());
    log.info("Update movie rating after adding review...");
    movie.setRating((float) ratingList.stream().mapToDouble(d -> d).average().orElse(0.0));
    save(movie);
  }
}
