package com.example.spring_course.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;
// Scored objects might be TV series, fast food, beer, etc. So create base object and extend on subclasses
//  Like public ScoredObject
//  public Movie extends ScoredObject
//  and use as
//  ScoredObject movie = new Movie()
  @Column(name = "type")
  private String type;

  @Column(name = "releaseYear")
  private Integer releaseYear;

  @Column(name = "description")
  private String description;

  @Column(name = "poster")
  private String poster;

  @Column(name = "rating")
  private Float rating;

//  @ManyToMany(mappedBy = "movies")
//  private List<Directors> directors;

  @ManyToMany
  @JoinTable(
          name = "movie_genres",
          joinColumns = @JoinColumn(name = "movie_id"),
          inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private List<Genre> genres;

  @Column(name = "createdTimestamp")
  private Date createdTimestamp;

  @Column(name = "lastUpdateTimestamp")
  private Date lastUpdateTimestamp;

  @OneToMany(mappedBy = "movie")
  private List<Review> reviews;

  public Movie() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(Float rating) {
    this.rating = rating;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public void setGenres(List<Genre> genres) {
    this.genres = genres;
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

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
