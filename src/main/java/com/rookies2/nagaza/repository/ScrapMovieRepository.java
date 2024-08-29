package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import com.rookies2.nagaza.entity.Movie;
import com.rookies2.nagaza.entity.ScrapList;
import com.rookies2.nagaza.entity.ScrapMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapMovieRepository extends JpaRepository<ScrapMovie, Integer> {
    boolean existsByScrapListAndMovie(ScrapList scrapList, Movie movie);
    List<ScrapMovie> findByScrapList(ScrapList scrapList);
    Optional<ScrapMovie> findByScrapListIdAndMovieId(Integer scrapListId, Integer movieId);
}

