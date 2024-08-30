package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findById(Integer movieId);
}
