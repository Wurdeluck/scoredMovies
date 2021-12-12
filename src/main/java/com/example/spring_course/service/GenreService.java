package com.example.spring_course.service;

import com.example.spring_course.entity.Genre;
import com.example.spring_course.repository.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
  private static final Logger log = LoggerFactory.getLogger(GenreService.class);

  private final GenreRepository genreRepository;

  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }
}
