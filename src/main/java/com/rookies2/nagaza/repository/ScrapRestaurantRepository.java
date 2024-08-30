package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapRestaurant;
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapRestaurantRepository extends JpaRepository<ScrapRestaurant, Integer> {
    Optional<ScrapRestaurant> findByUserAndRestaurantId (User user, Integer restaurantId);
    List<ScrapRestaurant> findByUserId(Integer userId);
}
