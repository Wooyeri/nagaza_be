package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Hotel;
import lombok.Data;

@Data
public class HotelDTO {
    private Integer id;
    private String name;
    private String posterUrl;
    private String location;
    private Integer emotionRating;
    private Integer likeCount;

    // 추가할 생성자
    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.posterUrl = hotel.getPosterUrl();
        this.location = hotel.getLocation();
        this.emotionRating = hotel.getEmotionRating();
        this.likeCount = hotel.getLikeCount();
    }
}
