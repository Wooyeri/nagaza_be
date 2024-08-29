package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private Integer id;
    private String name;
    private String posterUrl;
    private String foodType;
    private String reviewSummary;
    private String reviews;
    private Integer emotionRating;
    private Integer likeCount;

    public RestaurantDTO(Restaurant restaurant) {
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
}
