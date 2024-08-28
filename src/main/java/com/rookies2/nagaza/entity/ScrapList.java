package com.rookies2.nagaza.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

/**
 * 스크랩 리스트를 나타내는 엔티티 클래스입니다.
 * 사용자별로 여러 스크랩 리스트를 가질 수 있습니다.
 */
@Entity
@Table(name = "SCRAP_LIST")
@Data
public class ScrapList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;  // 스크랩 리스트 이름

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "scrapList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScrapMovie> scrapMovies;  // 스크랩된 영화 리스트
}


