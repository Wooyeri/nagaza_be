package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapMovie;
import com.rookies2.nagaza.entity.ScrapList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapMovieRepository extends JpaRepository<ScrapMovie, Integer> {
    List<ScrapMovie> findByScrapList(ScrapList scrapList);
    Optional<ScrapMovie> findByScrapListIdAndMovieId(Integer scrapListId, Integer movieId);
}
