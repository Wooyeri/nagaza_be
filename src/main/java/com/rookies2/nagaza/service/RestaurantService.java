package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto getRestaurantList(int id);
    RestaurantDto toggleLike(Integer restaurantId, Integer userId);
    boolean isLiked(Integer restaurantId, Integer userId);
    List<RestaurantDto> getLikeList(Integer userId);
}