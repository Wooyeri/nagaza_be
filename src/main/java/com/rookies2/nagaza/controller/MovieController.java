package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.MovieDetailDTO;
import com.rookies2.nagaza.entity.Movie;
import com.rookies2.nagaza.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 모든 영화를 조회하는 엔드포인트입니다.
     *
     * @return 모든 MovieDTO의 목록
     */
    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * 특정 ID에 해당하는 영화를 조회하는 엔드포인트입니다.
     *
     * @param id 조회할 Movie의 ID
     * @return 조회된 MovieDetailDTO 또는 null
     */
    @GetMapping("/{id}")
    public MovieDetailDTO getMovieById(@PathVariable Integer id) {
        return movieService.getMovieById(id);
    }

    /**
     * 특정 영화의 좋아요 수를 1 증가시키는 엔드포인트입니다.
     *
     * @param id 좋아요 수를 증가시킬 영화의 ID
     */
    @PostMapping("/{id}/like")
    public void incrementLikeCount(@PathVariable Integer id) {
        Movie movie = movieService.getMovieEntityById(id);
        if (movie != null) {
            movieService.incrementLikeCount(movie);
        }
    }

    /**
     * 특정 영화의 좋아요 수를 1 감소시키는 엔드포인트입니다.
     *
     * @param id 좋아요 수를 감소시킬 영화의 ID
     */
    @PostMapping("/{id}/unlike")
    public void decrementLikeCount(@PathVariable Integer id) {
        Movie movie = movieService.getMovieEntityById(id);
        if (movie != null) {
            movieService.decrementLikeCount(movie);
        }
    }
}
