package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapMovie;
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapMovieRepository extends JpaRepository<ScrapMovie, Integer> {
    Optional<ScrapMovie> findByUserAndMovieId (User user, Integer movieId);
    List<ScrapMovie> findByUserId(Integer userId);
}
