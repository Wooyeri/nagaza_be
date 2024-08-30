package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCRAP_RESTAURANT")
@Data
@NoArgsConstructor
public class ScrapRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public ScrapRestaurant(User user, Restaurant restaurant){
        this.user = user;
        this.restaurant = restaurant;
    }
}
