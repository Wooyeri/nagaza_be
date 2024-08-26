
package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRAP_HOTEL")
public class ScrapHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scrap_list_id", nullable = false)
    private ScrapList scrapList;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    // Getters and Setters
}
