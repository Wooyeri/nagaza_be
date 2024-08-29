package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.entity.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    RestaurantDTO toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantDTO restaurantDto);
}
