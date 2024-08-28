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

    /**
     * 데이터베이스에서 모든 영화를 조회합니다.
     *
     * @return MovieDTO 목록
     */
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * 주어진 ID로 특정 영화를 조회합니다.
     *
     * @param id 영화 ID
     * @return 조회된 MovieDetailDTO 또는 null
     */
    public MovieDetailDTO getMovieById(Integer id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        return movie != null ? convertToDetailDTO(movie) : null;
    }

    /**
     * 주어진 ID로 특정 영화 엔티티를 조회합니다.
     * 이 메서드는 주로 컨트롤러에서 좋아요 증가/감소를 위해 사용됩니다.
     *
     * @param id 영화 ID
     * @return 조회된 Movie 엔티티 또는 null
     */
    public Movie getMovieEntityById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    /**
     * Movie 엔티티를 MovieDTO로 변환합니다.
     *
     * @param movie 변환할 Movie 엔티티
     * @return 변환된 MovieDTO
     */
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

    /**
     * Movie 엔티티를 MovieDetailDTO로 변환합니다.
     *
     * @param movie 변환할 Movie 엔티티
     * @return 변환된 MovieDetailDTO
     */
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
        return dto;
    }

    /**
     * 주어진 영화의 좋아요 수를 1 증가시킵니다.
     *
     * @param movie 좋아요 수를 증가시킬 영화 엔티티
     */
    public void incrementLikeCount(Movie movie) {
        movie.setLikeCount(movie.getLikeCount() == null ? 1 : movie.getLikeCount() + 1);
        movieRepository.save(movie);
    }

    /**
     * 주어진 영화의 좋아요 수를 1 감소시킵니다. (0보다 작아질 수 없습니다.)
     *
     * @param movie 좋아요 수를 감소시킬 영화 엔티티
     */
    public void decrementLikeCount(Movie movie) {
        if (movie.getLikeCount() != null && movie.getLikeCount() > 0) {
            movie.setLikeCount(movie.getLikeCount() - 1);
            movieRepository.save(movie);
        }
    }
}
