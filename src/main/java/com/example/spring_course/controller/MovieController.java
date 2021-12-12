package com.example.spring_course.controller;

import com.example.spring_course.entity.Movie;
import com.example.spring_course.entity.Review;
import com.example.spring_course.service.MovieService;
import com.example.spring_course.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
  private static final Logger log = LoggerFactory.getLogger(MovieController.class);

  private final MovieService movieService;
  private final ReviewService reviewService;

  public MovieController(MovieService movieService, ReviewService reviewService) {
    this.movieService = movieService;
    this.reviewService = reviewService;
  }

//  @RequestMapping(value = "/popular", method = RequestMethod.GET)
//  public List<Movie> getPopularMovies() {
//    log.info("Fetch popular Movies...");
//    List<Movie> list = movieService.getAllMovies();
//    log.debug(": " + list.size());
//    List<Movie> ratedMovies = list.parallelStream().filter(obj -> null != obj.getRating())
//            .collect(Collectors.toList());
//    log.debug(": " + ratedMovies.size());
//    return ratedMovies;
//  }

  @GetMapping("/{movieId}")
  public Movie getMovie(@PathVariable("movieId") Long movieId) {
    return movieService.getMovie(movieId);
  }

  @PostMapping("/{movieId}/review")
  public Review addMovieReview(@RequestBody Review review) {
    log.info("Add movie review");
    return reviewService.addReview(review);
  }

  @GetMapping("/all")
  public List<Movie> getAllMovies() {
    log.info("Fetch all the movies");
    return movieService.getAllMovies();
  }

  @PostMapping("/")
  public Movie addMovie(@RequestBody Movie movie) {
    log.info("Add a movie");
    return movieService.addMovie(movie);
  }

}
