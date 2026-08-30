package com.balajidontul.repository;

import com.balajidontul.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepo extends JpaRepository<Movie, Long> {
}
