package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MovieLikeRepository extends JpaRepository<MovieLike, Integer> {
    Optional<MovieLike> findByUserAndMovie(User user, Movie movie);
    Optional<MovieLike> findByUserIdAndMovieId(Integer userId, Integer movieId);
    @Query("SELECT ml.movie FROM MovieLike ml WHERE ml.user.id = :userId")
    List<Movie> findMovieByUserId(@Param("userId") Integer userId);
}
