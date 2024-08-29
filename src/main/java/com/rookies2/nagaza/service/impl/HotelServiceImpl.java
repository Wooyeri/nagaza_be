package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.HotelDto;
import com.rookies2.nagaza.entity.*;
import com.rookies2.nagaza.mapper.HotelMapper;
import com.rookies2.nagaza.repository.HotelLikeRepository;
import com.rookies2.nagaza.repository.HotelRepository;
import com.rookies2.nagaza.repository.UserRepository;
import com.rookies2.nagaza.service.HotelService;
import com.rookies2.nagaza.service.LikeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService, LikeService<HotelDto> {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelLikeRepository hotelLikeRepository;

    @Autowired
    private UserRepository userRepository;
    private final HotelMapper hotelMapper;

    @Autowired
    public HotelServiceImpl(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }
    @Override
    public HotelDto toggleLike(Integer hotelId, Integer userId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("hotel not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Optional<HotelLike> existingLike = hotelLikeRepository.findByUserAndHotel(user, hotel);

        if (existingLike.isPresent()) {
            // 이미 좋아요가 존재하면 삭제하고 좋아요 수를 감소시킵니다.
            hotelLikeRepository.delete(existingLike.get());
            hotel.setLikeCount(hotel.getLikeCount() - 1);
        } else {
            // 좋아요가 없으면 새로 추가하고 좋아요 수를 증가시킵니다.
            HotelLike newLike = new HotelLike(user, hotel);
            hotelLikeRepository.save(newLike);
            hotel.setLikeCount(hotel.getLikeCount() + 1);
        }

        // 변경된 좋아요 수를 저장합니다.
        hotelRepository.save(hotel);

        // DTO로 변환해서 반환합니다.
        return new HotelDto(hotel);
    }

    @Override
    public boolean isLiked(Integer hotelId, Integer userId) {
        return hotelLikeRepository.findByUserIdAndHotelId(userId, hotelId).isPresent();
    }

    @Override
    public List<HotelDto> getLikeList(Integer userId) {
        List<Hotel> likedHotels = hotelLikeRepository.findHotelByUserId(userId);
        return likedHotels.stream()
                .map(hotel -> hotelMapper.toDto(hotel))
                .collect(Collectors.toList());
    }
}
