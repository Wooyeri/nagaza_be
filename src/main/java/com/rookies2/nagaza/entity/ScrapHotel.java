package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCRAP_HOTEL")
@Data
@NoArgsConstructor
public class ScrapHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public ScrapHotel(User user, Hotel hotel){
        this.user = user;
        this.hotel = hotel;
    }
}
