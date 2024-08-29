package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.MovieDto;
import com.rookies2.nagaza.dto.RestaurantDto;

import java.util.List;

public interface MovieService {
    MovieDto toggleLike(Integer movieId, Integer userId);
    boolean isLiked(Integer movieId, Integer userId);
    List<MovieDto> getLikeList(Integer userId);
}
