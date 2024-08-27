package com.rookies2.nagaza.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRAP_LIST")
public class ScrapList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    // Getters and Setters
}