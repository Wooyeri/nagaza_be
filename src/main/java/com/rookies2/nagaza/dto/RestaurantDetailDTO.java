package com.rookies2.nagaza.dto;

import lombok.Data;

@Data
public class RestaurantDetailDTO {
    private Integer id;
    private String name;
    private String posterUrl;
    private String foodType;
    private String reviewSummary;
    private String review;
    private Integer emotionRating;
    private Integer likeCount;
}
