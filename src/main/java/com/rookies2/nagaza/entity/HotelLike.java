package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOTEL_LIKE")
public class HotelLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    // Getters and Setters
}
