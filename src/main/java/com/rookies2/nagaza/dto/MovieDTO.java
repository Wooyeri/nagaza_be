package com.rookies2.nagaza.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private Integer id;
    private String title;
    private String posterUrl;
    private String cast;
    private String rating;
    private Integer emotionRating; 
    private Integer likeCount; 

    // Getters and Setters (Lombok을 통해 자동 생성)
}