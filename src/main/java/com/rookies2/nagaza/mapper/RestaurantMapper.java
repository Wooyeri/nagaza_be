package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDto toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantDto restaurantDto);
}
