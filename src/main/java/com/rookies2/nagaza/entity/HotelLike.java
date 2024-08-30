package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOTEL_LIKE")
@NoArgsConstructor
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

    public HotelLike(User user, Hotel hotel){
        this.user = user;
        this.hotel = hotel;
    }
}
