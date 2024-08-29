package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.MovieDto;
import com.rookies2.nagaza.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/like/{id}")
    public ResponseEntity<MovieDto> toggleMovieLike(@PathVariable("id") Integer movieId, @RequestParam Integer userId) {
        MovieDto movieDto = movieService.toggleLike(movieId, userId);
        return ResponseEntity.ok(movieDto);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Boolean> isMovieLiked(@PathVariable("id") Integer movieId, @RequestParam Integer userId) {
        boolean isLiked = movieService.isLiked(movieId, userId);
        return ResponseEntity.ok(isLiked);
    }
    
    @GetMapping("/likes")
    public ResponseEntity<List<MovieDto>> getLikedMovies(@RequestParam Integer userId) {
        List<MovieDto> likedMovies = movieService.getLikeList(userId);
        return ResponseEntity.ok(likedMovies);
    }
}
