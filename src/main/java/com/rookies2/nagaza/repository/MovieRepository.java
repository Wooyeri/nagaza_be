package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
