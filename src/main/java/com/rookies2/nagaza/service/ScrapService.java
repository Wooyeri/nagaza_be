package com.rookies2.nagaza.service;


import com.rookies2.nagaza.dto.ScrapDTO;

import java.util.List;

public interface ScrapService {
    void toggleScrap(Integer itemId, Integer userId, String category);
    List<ScrapDTO> getScrapList(Integer userId, String category);

}


