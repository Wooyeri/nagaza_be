package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Optional<Restaurant> findById(Integer restaurantId);
}

