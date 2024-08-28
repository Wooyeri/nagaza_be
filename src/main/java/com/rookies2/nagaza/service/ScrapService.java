package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.RestaurantDto;

import java.util.List;

public interface ScrapService {
    List<MovieDTO> getMovieScrapList(Integer userId);
    List<RestaurantDto> getRestaurantScrapList(Integer userId);
    List<HotelDTO> getHotelScrapList(Integer userId);
    void createMovieScrap(Integer userId, Integer movieId);
    void createRestaurantScrap(Integer userId, Integer restaurantId);
    void createHotelScrap(Integer userId, Integer hotelId);
    void deleteMovieScrap(Integer scrapListId, Integer movieId);
    void deleteRestaurantScrap(Integer scrapListId, Integer restaurantId);
    void deleteHotelScrap(Integer scrapListId, Integer hotelId);
}
