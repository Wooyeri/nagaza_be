package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.MovieDto;
import com.rookies2.nagaza.entity.*;
import com.rookies2.nagaza.mapper.MovieMapper;
import com.rookies2.nagaza.repository.MovieLikeRepository;
import com.rookies2.nagaza.repository.MovieRepository;
import com.rookies2.nagaza.repository.UserRepository;
import com.rookies2.nagaza.service.LikeService;
import com.rookies2.nagaza.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService, LikeService<MovieDto> {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieLikeRepository movieLikeRepository;

    @Autowired
    private UserRepository userRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieServiceImpl(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }
    @Override
    public MovieDto toggleLike(Integer movieId, Integer userId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("movie not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Optional<MovieLike> existingLike = movieLikeRepository.findByUserAndMovie(user, movie);

        if (existingLike.isPresent()) {
            // 이미 좋아요가 존재하면 삭제하고 좋아요 수를 감소시킵니다.
            movieLikeRepository.delete(existingLike.get());
            movie.setLikeCount(movie.getLikeCount() - 1);
        } else {
            // 좋아요가 없으면 새로 추가하고 좋아요 수를 증가시킵니다.
            MovieLike newLike = new MovieLike(user, movie);
            movieLikeRepository.save(newLike);
            movie.setLikeCount(movie.getLikeCount() + 1);
        }

        // 변경된 좋아요 수를 저장합니다.
        movieRepository.save(movie);

        // DTO로 변환해서 반환합니다.
        return new MovieDto(movie);
    }

    @Override
    public boolean isLiked(Integer movieId, Integer userId) {
        return movieLikeRepository.findByUserIdAndMovieId(userId, movieId).isPresent();
    }

    @Override
    public List<MovieDto> getLikeList(Integer userId) {
        List<Movie> likedMovies = movieLikeRepository.findMovieByUserId(userId);
        return likedMovies.stream()
                .map(movie -> movieMapper.toDto(movie))
                .collect(Collectors.toList());
    }
}
