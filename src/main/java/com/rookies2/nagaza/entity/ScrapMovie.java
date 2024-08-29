package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 스크랩된 영화를 나타내는 엔티티 클래스입니다.
 */
@Entity
@Table(name = "SCRAP_MOVIE")
@Data
public class ScrapMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scrap_list_id", nullable = false)
    private ScrapList scrapList;  // 스크랩 리스트

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;  // 스크랩된 영화
}

