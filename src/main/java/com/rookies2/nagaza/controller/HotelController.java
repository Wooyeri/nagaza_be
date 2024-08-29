package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.HotelDto;
import com.rookies2.nagaza.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/like/{id}")
    public ResponseEntity<HotelDto> toggleHotelLike(@PathVariable("id") Integer hotelId, @RequestParam Integer userId) {
        HotelDto hotelDto = hotelService.toggleLike(hotelId, userId);
        return ResponseEntity.ok(hotelDto);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Boolean> isHotelLiked(@PathVariable("id") Integer hotelId, @RequestParam Integer userId) {
        boolean isLiked = hotelService.isLiked(hotelId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<HotelDto>> getLikedHotels(@RequestParam Integer userId) {
        List<HotelDto> likedHotels = hotelService.getLikeList(userId);
        return ResponseEntity.ok(likedHotels);
    }
}

