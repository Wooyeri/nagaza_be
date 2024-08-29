package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Hotel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    private Integer id;
    private String name;
    private String posterUrl;
    private String location;
    private String detailedUrl;
    private String reviewSummary;
    private String reviews;
    private Integer emotionRating;
    private Integer likeCount;

    public HotelDto(Hotel hotel) {
        if (hotel != null) {
            this.id = hotel.getId();
            this.name = hotel.getName();
            this.posterUrl = hotel.getPosterUrl();
            this.location = hotel.getLocation();
            this.detailedUrl = hotel.getDetailedUrl();
            this.reviewSummary = hotel.getReviewSummary();
            this.reviews = hotel.getReviews();
            this.emotionRating = hotel.getEmotionRating();
            this.likeCount = hotel.getLikeCount();
        }
    }
}
