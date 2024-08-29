package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.entity.Hotel;

public class HotelMapper {
    public static HotelDTO toDto(Hotel hotel) {
        return new HotelDTO(hotel);
    }
}

