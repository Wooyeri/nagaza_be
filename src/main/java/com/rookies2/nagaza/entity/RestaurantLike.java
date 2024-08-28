package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESTAURANT_LIKE")
@NoArgsConstructor
public class RestaurantLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public RestaurantLike(User user, Restaurant restaurant){
        this.user = user;
        this.restaurant = restaurant;
    }
}
