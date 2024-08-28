package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.RestaurantDetailDTO;
import com.rookies2.nagaza.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantList(int id);
    RestaurantDetailDTO getRestaurantDetail(int id);  // New method for detailed view
    RestaurantDto toggleLike(Integer restaurantId, Integer userId);
    boolean isLiked(Integer restaurantId, Integer userId);
}



