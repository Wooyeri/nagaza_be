package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapList;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ScrapList 엔티티에 대한 데이터베이스 작업을 수행하는 리포지토리 인터페이스입니다.
 */
public interface ScrapListRepository extends JpaRepository<ScrapList, Integer> {
    
    // 스크랩 리스트를 이름으로 조회하는 메서드
    ScrapList findByName(String name);
}
