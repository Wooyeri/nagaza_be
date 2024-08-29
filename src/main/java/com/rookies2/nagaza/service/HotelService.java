package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDto;
import com.rookies2.nagaza.dto.MovieDto;

import java.util.List;

public interface HotelService {
    HotelDto toggleLike(Integer hotelId, Integer userId);
    boolean isLiked(Integer hotelId, Integer userId);
    List<HotelDto> getLikeList(Integer userId);
}
