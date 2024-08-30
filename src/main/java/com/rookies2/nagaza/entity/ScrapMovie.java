package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCRAP_MOVIE")
@Data
@NoArgsConstructor
public class ScrapMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public ScrapMovie(User user, Movie movie){
        this.user = user;
        this.movie = movie;
    }
}

