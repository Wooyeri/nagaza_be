package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.entity.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(HotelDTO hotelDto);
    HotelDTO toDto(Hotel hotel);
}
