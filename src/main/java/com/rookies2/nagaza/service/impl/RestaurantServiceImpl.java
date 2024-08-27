package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.entity.Restaurant;
import com.rookies2.nagaza.repository.RestaurantRepository;
import com.rookies2.nagaza.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto getRestaurantList(int id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        return RestaurantDto.EntityToDto(restaurant);
    }
}
