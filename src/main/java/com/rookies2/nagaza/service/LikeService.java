package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.RestaurantDTO;

import java.util.List;

public interface LikeService<T> {
    T toggleLike(Integer id, Integer userId);
    boolean isLiked(Integer id, Integer userId);
    List<T> getLikeList(Integer userId);
}