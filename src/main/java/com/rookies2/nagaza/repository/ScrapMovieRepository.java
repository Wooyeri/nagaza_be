package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ScrapMovie 엔티티에 대한 데이터베이스 작업을 수행하는 리포지토리 인터페이스입니다.
 */
public interface ScrapMovieRepository extends JpaRepository<ScrapMovie, Integer> {

    /**
     * 주어진 ScrapList ID에 속한 모든 ScrapMovie를 조회하는 메서드입니다.
     *
     * @param scrapListId ScrapList의 ID
     * @return 해당 ScrapList에 속한 ScrapMovie 목록
     */
    List<ScrapMovie> findAllByScrapListId(Integer scrapListId);
}

