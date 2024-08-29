package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.entity.Restaurant;

public class RestaurantMapper {
    public static RestaurantDto toDto(Restaurant restaurant) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        // 기타 필요한 필드 추가
        return dto;
    }
}
