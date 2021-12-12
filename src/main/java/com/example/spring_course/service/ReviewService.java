package com.example.spring_course.service;

import com.example.spring_course.entity.Movie;
import com.example.spring_course.entity.Review;
import com.example.spring_course.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService {
  private static final Logger log = LoggerFactory.getLogger(MovieService.class);

  private final ReviewRepository reviewRepository;
  private final MovieService movieService;

  public ReviewService(ReviewRepository reviewRepository, MovieService movieService) {
    this.reviewRepository = reviewRepository;
    this.movieService = movieService;
  }

  public Review save(Review review) {
    review.setLastUpdateTimestamp(new Date());
    log.info("Saving review with ID: ''{}''", review.getId());
    return reviewRepository.save(review);
  }

  public Review addReview(Review review) {
    review.setCreatedTimestamp(new Date());
    Review reviewSaved = save(review);
    Movie movie = review.getMovie();
    movieService.updateRating(movie.getId());
    return reviewSaved;
  }
}
