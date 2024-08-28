package com.rookies2.nagaza.service;

<<<<<<< HEAD
import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.dto.RestaurantDetailDTO;
import com.rookies2.nagaza.entity.Restaurant;
import com.rookies2.nagaza.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RestaurantDetailDTO getRestaurantDetailById(Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if (restaurant == null) {
            return null;
        }
        return convertToDetailDTO(restaurant);
    }

    public Restaurant getRestaurantEntityById(Integer id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setPosterUrl(restaurant.getPosterUrl());
        dto.setFoodType(restaurant.getFoodType());
        dto.setEmotionRating(restaurant.getEmotionRating());
        dto.setLikeCount(restaurant.getLikeCount());
        return dto;
    }

    private RestaurantDetailDTO convertToDetailDTO(Restaurant restaurant) {
        RestaurantDetailDTO dto = new RestaurantDetailDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setPosterUrl(restaurant.getPosterUrl());
        dto.setFoodType(restaurant.getFoodType());
        dto.setReviewSummary(restaurant.getReviewSummary());
        dto.setReview(restaurant.getReviews());
        dto.setEmotionRating(restaurant.getEmotionRating());
        dto.setLikeCount(restaurant.getLikeCount());
        return dto;
    }

    public void incrementLikeCount(Restaurant restaurant) {
        restaurant.setLikeCount(restaurant.getLikeCount() == null ? 1 : restaurant.getLikeCount() + 1);
        restaurantRepository.save(restaurant);
    }

    public void decrementLikeCount(Restaurant restaurant) {
        if (restaurant.getLikeCount() != null && restaurant.getLikeCount() > 0) {
            restaurant.setLikeCount(restaurant.getLikeCount() - 1);
            restaurantRepository.save(restaurant);
        }
    }
}
=======
import com.rookies2.nagaza.dto.RestaurantDto;

public interface RestaurantService {
    RestaurantDto getRestaurantList(int id);
    RestaurantDto toggleLike(Integer restaurantId, Integer userId);
    boolean isLiked(Integer restaurantId, Integer userId);

}
>>>>>>> origin/feature/403/Success
