package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Restaurant 엔티티에 대한 데이터베이스 작업을 수행하는 리포지토리 인터페이스입니다.
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
