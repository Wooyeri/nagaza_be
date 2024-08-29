package com.rookies2.nagaza.dto;

import lombok.Data;

@Data
public class HotelDetailDTO {
    private Integer id;
    private String name;
    private String posterUrl;
    private String location;
    private String reviewSummary;
    private String reviews;
    private Integer emotionRating; 
    private Integer likeCount; 

    // Getters and Setters (Lombok을 통해 자동 생성)
}