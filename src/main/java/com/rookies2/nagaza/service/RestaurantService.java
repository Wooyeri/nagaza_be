package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.RestaurantDTO;
import java.util.List;
import com.rookies2.nagaza.dto.RestaurantDTO;


public interface RestaurantService {
    RestaurantDTO getRestaurantList(int id);
    RestaurantDTO toggleLike(Integer restaurantId, Integer userId);
    boolean isLiked(Integer restaurantId, Integer userId);

    List<RestaurantDTO> getLikeList(Integer userId);
}