package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String posterUrl;

    private String location;

    private String detailedUrl;

    private String reviewSummary;

    private String reviews;

    private Integer emotionRating;

    // Getters and Setters
}