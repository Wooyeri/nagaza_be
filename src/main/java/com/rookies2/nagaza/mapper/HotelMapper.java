package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.HotelDto;
import com.rookies2.nagaza.entity.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(HotelDto hotelDto);
    HotelDto toDto(Hotel hotel);
}
