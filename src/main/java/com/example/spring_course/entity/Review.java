package com.example.spring_course.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "reviewText")
  private String reviewText;

  @Column(name = "movieRating")
  private float movieRating;

  @Column(name = "reviewRating")
  private int reviewRating;

  @Column(name = "createdTimestamp")
  private Date createdTimestamp;

  @Column(name = "lastUpdateTimestamp")
  private Date lastUpdateTimestamp;

  public Review() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public float getMovieRating() {
    return movieRating;
  }

  public void setMovieRating(float rating) {
    this.movieRating = rating;
  }

  public int getReviewRating() {
    return reviewRating;
  }

  public void setReviewRating(int reviewRating) {
    this.reviewRating = reviewRating;
  }

  public Date getCreatedTimestamp() {
    return createdTimestamp;
  }

  public void setCreatedTimestamp(Date createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  public Date getLastUpdateTimestamp() {
    return lastUpdateTimestamp;
  }

  public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
    this.lastUpdateTimestamp = lastUpdateTimestamp;
  }
}
