package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "RESTAURANT")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String posterUrl;

    private String foodType;

    @Column(length = 1000)
    private String reviewSummary;

    @Column(length = 1000)
    private String reviews;

    private Integer emotionRating;

    private Integer likeCount;
    // Getters and Setters
}