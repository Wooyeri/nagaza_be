package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.MovieDetailDTO;
import com.rookies2.nagaza.entity.Movie;
import com.rookies2.nagaza.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MovieDetailDTO getMovieDetailById(Integer id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie == null) {
            return null;
        }
        return convertToDetailDTO(movie);
    }

    public Movie getMovieEntityById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setCast(movie.getCast());
        dto.setRating(movie.getRating());
        dto.setEmotionRating(movie.getEmotionRating()); 
        dto.setLikeCount(movie.getLikeCount()); 
        return dto;
    }

    private MovieDetailDTO convertToDetailDTO(Movie movie) {
        MovieDetailDTO dto = new MovieDetailDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setPosterUrl(movie.getPosterUrl());
        dto.setCast(movie.getCast());
        dto.setRating(movie.getRating());
        dto.setEmotionRating(movie.getEmotionRating());
        dto.setLikeCount(movie.getLikeCount());
        dto.setReviewSummary(movie.getReviewSummary());
        dto.setReviews(movie.getReviews());
        dto.setDirector(movie.getDirector());
        return dto;
    }

    public void incrementLikeCount(Movie movie) {
        movie.setLikeCount(movie.getLikeCount() == null ? 1 : movie.getLikeCount() + 1);
        movieRepository.save(movie);
    }

    public void decrementLikeCount(Movie movie) {
        if (movie.getLikeCount() != null && movie.getLikeCount() > 0) {
            movie.setLikeCount(movie.getLikeCount() - 1);
            movieRepository.save(movie);
        }
    }
}