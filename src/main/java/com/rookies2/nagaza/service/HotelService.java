package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.HotelDetailDTO;
import com.rookies2.nagaza.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<HotelDTO> getAllHotels();
    HotelDetailDTO getHotelDetailById(Integer id);
    Hotel getHotelEntityById(Integer id);
    HotelDTO toggleLike(Integer hotelId, Integer userId);
    boolean isLiked(Integer hotelId, Integer userId);
    List<HotelDTO> getLikeList(Integer userId);
}


