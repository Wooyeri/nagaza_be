package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Movie;
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

    // 추가할 생성자
    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.posterUrl = movie.getPosterUrl();
        this.cast = movie.getCast();
        this.rating = movie.getRating();
        this.emotionRating = movie.getEmotionRating();
        this.likeCount = movie.getLikeCount();
    }
}
