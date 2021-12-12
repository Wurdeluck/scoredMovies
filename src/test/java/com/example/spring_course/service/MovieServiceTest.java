package com.example.spring_course.service;

import com.example.spring_course.entity.*;
import com.example.spring_course.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@SpringBootTest
@ActiveProfiles("test")
class MovieServiceTest {

  @Autowired
  MovieService movieService;

  @Autowired
  MovieRepository movieRepository;

  @Autowired
  GenreRepository genreRepository;

  @Autowired
  ReviewRepository reviewRepository;

  @Autowired
  AuthorityRepository authorityRepository;

  @Autowired
  UserRepository userRepository;

  @BeforeEach
  public void init() {
    Authority authority = new Authority();
    authority.setRole("ADMIN");
    Authority savedAuthority = authorityRepository.save(authority);
    Authority authority2 = new Authority();
    authority2.setRole("USER");
    Authority savedAuthority2 = authorityRepository.save(authority2);
    User user = new User();
    user.setUsername("admin");
    user.setPassword("admin");
    user.setEnabled(true);
    user.setAuthorities(Arrays.asList(savedAuthority, savedAuthority2));
    User savedUser = userRepository.save(user);
    Genre genre = new Genre();
    genre.setName("thriller");
    Genre savedGenre = genreRepository.save(genre);
    Genre genre2 = new Genre();
    genre2.setName("comedy");
    Genre savedGenre2 = genreRepository.save(genre2);
    Movie movie = new Movie();
    movie.setTitle("A Simple Favor");
    movie.setType("movie");
    movie.setReleaseYear(2008);
    movie.setDescription("Nice movie");
    movie.setPoster("I dunno how but picture will be here");
    movie.setRating(null);
    movie.setCreatedTimestamp(new Date());
    movie.setLastUpdateTimestamp(new Date());
    movie.setGenres(Arrays.asList(savedGenre, savedGenre2));
    Movie movieSavedNoReviews = movieService.addMovie(movie);
    Review review = new Review();
    review.setCreatedTimestamp(new Date());
    review.setReviewText("I did surprise");
    review.setLastUpdateTimestamp(new Date());
    review.setMovie(movieSavedNoReviews);
    review.setMovieRating(7.5f);
    review.setReviewRating(0);
    review.setUser(savedUser);
    Review savedReview = reviewRepository.save(review);
    Review review2 = new Review();
    review2.setCreatedTimestamp(new Date());
    review2.setReviewText("I did surprise too");
    review2.setLastUpdateTimestamp(new Date());
    review2.setMovie(movieSavedNoReviews);
    review2.setMovieRating(8f);
    review2.setReviewRating(1);
    review2.setUser(savedUser);
    Review savedReview2 = reviewRepository.save(review2);
    movieSavedNoReviews.setReviews(Arrays.asList(savedReview, savedReview2));
    Movie movieSavedWithReviews = movieService.save(movieSavedNoReviews);
    Assertions.assertEquals(movieSavedWithReviews.getId(), movieService.getMovie(movieSavedWithReviews.getId()).getId());
  }

  @AfterEach
  public void cleanAll() {
    reviewRepository.deleteAll();
    movieRepository.deleteAll();
    System.out.println("Tak");
  }

  @Test
  public void addMovie() {
    Movie movie = new Movie();
    movie.setTitle("La cara oculta");
    movie.setType("movie");
    movie.setReleaseYear(2011);
    movie.setDescription("Ooo scary");
    movie.setPoster("I dunno how but picture will be here 2");
    movie.setRating(null);
    movie.setCreatedTimestamp(new Date());
    movie.setLastUpdateTimestamp(new Date());
    Genre genre = genreRepository.getByName("thriller");
    movie.setGenres(Collections.singletonList(genre));
    movieService.addMovie(movie);
    Assertions.assertEquals(2, movieService.getAllMovies().size());
  }

}