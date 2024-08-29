package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


/**
 * 영화 정보를 나타내는 엔티티 클래스입니다.
 */
@Entity
@Table(name = "MOVIE")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;  // 영화 제목

    @Column(length = 1000)
    private String posterUrl;  // 포스터 URL

    private String cast;  // 출연 배우

    private String rating;  // 평점

    @Column(length = 1000)
    private String reviewSummary;  // 리뷰 요약

    @Column(length = 1000)
    private String reviews;  // 리뷰 요약

    private Integer emotionRating;  // 감정 점수

    private Integer likeCount;  // 좋아요 수

    private String director;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScrapMovie> scrapMovies;  // 스크랩된 영화 리스트
}



