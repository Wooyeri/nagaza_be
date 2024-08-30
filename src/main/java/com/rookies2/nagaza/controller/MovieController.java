package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.MovieDetailDTO;
import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.entity.Movie;
import com.rookies2.nagaza.jwt.JWTUtil;
import com.rookies2.nagaza.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private JWTUtil jwtUtil;
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
    public ResponseEntity<MovieDetailDTO> getMovieDetail(@PathVariable Integer id) {
        MovieDetailDTO movie = movieService.getMovieDetailById(id); // 수정된 부분
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }


    @PostMapping("/like/{id}")
    public ResponseEntity<MovieDTO> toggleMovieLike(@PathVariable("id") Integer movieId, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);

        MovieDTO movieDto = movieService.toggleLike(movieId, userId);
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Boolean> isMovieLiked(@PathVariable("id") Integer movieId, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);

        boolean isLiked = movieService.isLiked(movieId, userId);
        return ResponseEntity.ok(isLiked);
    }


    @GetMapping("/likes")
    public ResponseEntity<List<MovieDTO>> getLikedMovies(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);

        List<MovieDTO> likedMovies = movieService.getLikeList(userId);
        return ResponseEntity.ok(likedMovies);
    }
}