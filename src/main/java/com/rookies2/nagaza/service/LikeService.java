package com.rookies2.nagaza.service;

public interface LikeService<T> {
    T toggleLike(Integer id, Integer userId);
    boolean isLiked(Integer id, Integer userId);
}
