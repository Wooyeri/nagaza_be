package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Restaurant;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private Integer id;
    private String name;
    private String posterUrl;
    private String foodType;
    private String reviewSummary;
    private String reviews;
    private Integer emotionRating;
    private Integer likeCount;

    public RestaurantDto(Restaurant restaurant) {
        if (restaurant != null) {
            this.id = restaurant.getId();
            this.name = restaurant.getName();
            this.posterUrl = restaurant.getPosterUrl();
            this.foodType = restaurant.getFoodType();
            this.reviewSummary = restaurant.getReviewSummary();
            this.reviews = restaurant.getReviews();
            this.emotionRating = restaurant.getEmotionRating();
            this.likeCount = restaurant.getLikeCount();
        }
    }

//    public RestaurantDto(Restaurant restaurant) {
//        RestaurantDto dto = new RestaurantDto();
//        dto.setId(restaurant.getId());
//        dto.setName(restaurant.getName());
//        dto.setPosterUrl(restaurant.getPosterUrl());
//        dto.setFoodType(restaurant.getFoodType());
//        dto.setReviewSummary(restaurant.getReviewSummary());
//        dto.setReviews(restaurant.getReviews());
//        dto.setEmotionRating(restaurant.getEmotionRating());
//        dto.setLikeCount(restaurant.getLikeCount());
//    }
}