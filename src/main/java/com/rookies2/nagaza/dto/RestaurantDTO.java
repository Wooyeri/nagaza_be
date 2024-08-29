package com.rookies2.nagaza.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Integer id;
    private String name;
    private String posterUrl;
    private String foodType;
    private Integer emotionRating;
    private Integer likeCount;
}
