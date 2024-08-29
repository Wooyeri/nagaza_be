package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.entity.ScrapList;

import java.util.List;

public interface ScrapService {
    List<MovieDTO> getMovieScrapList(Integer userId);
    List<HotelDTO> getHotelScrapList(Integer userId);
    void createMovieScrap(Integer userId, Integer movieId);
    void createHotelScrap(Integer userId, Integer hotelId);
    void deleteMovieScrap(Integer scrapListId, Integer movieId);
    void deleteHotelScrap(Integer scrapListId, Integer hotelId);

    // 추가된 메서드
    ScrapList getOrCreateScrapList(Integer userId, String listName);
}

