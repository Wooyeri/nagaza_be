package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRAP_RESTAURANT")
public class ScrapRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scrap_list_id", nullable = false)
    private ScrapList scrapList;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Getters and Setters
}
