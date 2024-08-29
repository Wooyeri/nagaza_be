package com.rookies2.nagaza.dto;

import com.rookies2.nagaza.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String title;
    private String posterUrl;
    private String director;
    private String cast;
    private String rating;
    private String reviewSummary;
    private String reviews;
    private Integer emotionRating;
    private Integer likeCount;
    public MovieDto(Movie movie) {
        if (movie != null) {
            this.id = movie.getId();
            this.title = movie.getTitle();
            this.posterUrl = movie.getPosterUrl();
            this.director = movie.getDirector();
            this.cast = movie.getCast();
            this.rating = movie.getRating();
            this.reviewSummary = movie.getReviewSummary();
            this.reviews = movie.getReviews();
            this.emotionRating = movie.getEmotionRating();
            this.likeCount = movie.getLikeCount();
        }
    }
}
