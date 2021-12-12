//package com.example.spring_course.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "directors")
//public class Directors {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//  private Long id;
//
//  @Column(name = "name")
//  private String name;
//
//  @ManyToMany
//  @JoinTable(name = "directors_movies",
//  joinColumns = @JoinColumn(name = "director_id"),
//  inverseJoinColumns = @JoinColumn(name = "movie_id"))
//  private List<Movies> movies;
//}
