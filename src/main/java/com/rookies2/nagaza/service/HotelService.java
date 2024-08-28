package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.HotelDetailDTO;
import com.rookies2.nagaza.entity.Hotel;
import com.rookies2.nagaza.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public HotelDetailDTO getHotelDetailById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        if (hotel == null) {
            return null;
        }
        return convertToDetailDTO(hotel);
    }

    public Hotel getHotelEntityById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    private HotelDTO convertToDTO(Hotel hotel) {
        return new HotelDTO(hotel); // 'hotel' 객체를 생성자에 전달
    }

    private HotelDetailDTO convertToDetailDTO(Hotel hotel) {
        HotelDetailDTO dto = new HotelDetailDTO();
        dto.setId(hotel.getId());
        dto.setName(hotel.getName());
        dto.setPosterUrl(hotel.getPosterUrl());
        dto.setLocation(hotel.getLocation());
        dto.setReviewSummary(hotel.getReviewSummary());
        dto.setReviews(hotel.getReviews());
        dto.setEmotionRating(hotel.getEmotionRating());
        dto.setLikeCount(hotel.getLikeCount());
        return dto;
    }

    public void incrementLikeCount(Hotel hotel) {
        hotel.setLikeCount(hotel.getLikeCount() == null ? 1 : hotel.getLikeCount() + 1);
        hotelRepository.save(hotel);
    }

    public void decrementLikeCount(Hotel hotel) {
        if (hotel.getLikeCount() != null && hotel.getLikeCount() > 0) {
            hotel.setLikeCount(hotel.getLikeCount() - 1);
            hotelRepository.save(hotel);
        }
    }
}