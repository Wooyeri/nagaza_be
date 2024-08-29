package com.rookies2.nagaza.service;


import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.RestaurantDTO;

import java.util.List;

public interface MovieService {
    MovieDTO toggleLike(Integer movieId, Integer userId);
    boolean isLiked(Integer movieId, Integer userId);
    List<MovieDTO> getLikeList(Integer userId);
}

