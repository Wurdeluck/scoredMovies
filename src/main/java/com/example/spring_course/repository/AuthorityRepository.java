package com.example.spring_course.repository;

import com.example.spring_course.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authorities", path = "authorities")
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
