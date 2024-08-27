package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRAP_MOVIE")
public class ScrapMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scrap_list_id", nullable = false)
    private ScrapList scrapList;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    // Getters and Setters
}
