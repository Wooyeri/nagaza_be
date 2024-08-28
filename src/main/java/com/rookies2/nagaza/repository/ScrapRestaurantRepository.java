package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapRestaurant;
import com.rookies2.nagaza.entity.ScrapList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapRestaurantRepository extends JpaRepository<ScrapRestaurant, Integer> {
    List<ScrapRestaurant> findByScrapList(ScrapList scrapList);
    Optional<ScrapRestaurant> findByScrapListIdAndRestaurantId(Integer scrapListId, Integer restaurantId);
}
