package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.RestaurantDTO;
import java.util.List;
import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.dto.RestaurantDetailDTO;


public interface RestaurantService {
    List<RestaurantDTO> getAllRestaurants();
    RestaurantDetailDTO getRestaurantDetail(int id);
    RestaurantDTO getRestaurantList(int id);
    RestaurantDTO toggleLike(Integer restaurantId, Integer userId);
    boolean isLiked(Integer restaurantId, Integer userId);

    List<RestaurantDTO> getLikeList(Integer userId);
}