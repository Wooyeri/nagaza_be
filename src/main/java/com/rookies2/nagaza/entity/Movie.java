package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MOVIE")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String posterUrl;

    private String director;

    private String cast;

    private String rating;

    @Column(length = 1000)
    private String reviewSummary;

    @Column(length = 1000)
    private String reviews;

    private Integer emotionRating;

    private Integer likeCount;
    // Getters and Setters
}
