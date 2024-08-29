package com.rookies2.nagaza.service;


import com.rookies2.nagaza.dto.ScrapDTO;

import java.util.List;

public interface ScrapService {
    void toggleScrap(Integer itemId, Integer userId, String category);
    List<ScrapDTO> getScrapList(Integer userId, String category);
    List<ScrapDTO> getMovieScraps(Integer userId);
    List<ScrapDTO> getHotelScraps(Integer userId);
    List<ScrapDTO> getRestaurantScraps(Integer userId);
    boolean isScrap(Integer itemId, Integer userId, String category);
}


