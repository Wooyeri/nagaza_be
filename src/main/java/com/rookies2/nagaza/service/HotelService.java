package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO toggleLike(Integer hotelId, Integer userId);
    boolean isLiked(Integer hotelId, Integer userId);
    List<HotelDTO> getLikeList(Integer userId);
}


