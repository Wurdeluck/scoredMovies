package com.example.spring_course.controller;

import com.example.spring_course.entity.Genre;
import com.example.spring_course.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(("/genres"))
public class GenreController {
  private static final Logger log = LoggerFactory.getLogger(GenreController.class);

  @Autowired
  GenreService genreService;

  @GetMapping("/")
  public List<Genre> getAllGenres() {
    return genreService.getAllGenres();
  }
}
