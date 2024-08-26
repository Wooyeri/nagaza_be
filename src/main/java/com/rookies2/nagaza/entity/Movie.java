package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String posterUrl;

    private String director;

    private String cast;

    private String rating;

    private String reviewSummary;

    private String reviews;

    private Integer emotionRating;

    // Getters and Setters
}
