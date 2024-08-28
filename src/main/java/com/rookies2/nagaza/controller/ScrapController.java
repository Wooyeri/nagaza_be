package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.service.ScrapService;
import com.rookies2.nagaza.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scrap")
public class ScrapController {

    @Autowired
    private ScrapService scrapService;

    // 영화 스크랩 목록 조회
    @GetMapping("/movie/list")
    public ResponseEntity<List<MovieDTO>> getMovieScrapList(@AuthenticationPrincipal User user) {
        List<MovieDTO> scrapList = scrapService.getMovieScrapList(user.getId());
        return ResponseEntity.ok(scrapList);
    }

    // 식당 스크랩 목록 조회
    @GetMapping("/restaurant/list")
    public ResponseEntity<List<RestaurantDto>> getRestaurantScrapList(@AuthenticationPrincipal User user) {
        List<RestaurantDto> scrapList = scrapService.getRestaurantScrapList(user.getId());
        return ResponseEntity.ok(scrapList);
    }

    // 호텔 스크랩 목록 조회
    @GetMapping("/hotel/list")
    public ResponseEntity<List<HotelDTO>> getHotelScrapList(@AuthenticationPrincipal User user) {
        List<HotelDTO> scrapList = scrapService.getHotelScrapList(user.getId());
        return ResponseEntity.ok(scrapList);
    }

    // 영화 스크랩 추가
    @PostMapping("/movie")
    public ResponseEntity<Void> createMovieScrap(@AuthenticationPrincipal User user, @RequestBody Integer movieId) {
        scrapService.createMovieScrap(user.getId(), movieId);
        return ResponseEntity.ok().build();
    }

    // 식당 스크랩 추가
    @PostMapping("/restaurant")
    public ResponseEntity<Void> createRestaurantScrap(@AuthenticationPrincipal User user, @RequestBody Integer restaurantId) {
        scrapService.createRestaurantScrap(user.getId(), restaurantId);
        return ResponseEntity.ok().build();
    }

    // 호텔 스크랩 추가
    @PostMapping("/hotel")
    public ResponseEntity<Void> createHotelScrap(@AuthenticationPrincipal User user, @RequestBody Integer hotelId) {
        scrapService.createHotelScrap(user.getId(), hotelId);
        return ResponseEntity.ok().build();
    }

    // 스크랩 삭제
    @DeleteMapping("/{scrapListId}/movie/{movieId}")
    public ResponseEntity<Void> deleteMovieScrap(@PathVariable Integer scrapListId, @PathVariable Integer movieId) {
        scrapService.deleteMovieScrap(scrapListId, movieId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{scrapListId}/restaurant/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurantScrap(@PathVariable Integer scrapListId, @PathVariable Integer restaurantId) {
        scrapService.deleteRestaurantScrap(scrapListId, restaurantId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{scrapListId}/hotel/{hotelId}")
    public ResponseEntity<Void> deleteHotelScrap(@PathVariable Integer scrapListId, @PathVariable Integer hotelId) {
        scrapService.deleteHotelScrap(scrapListId, hotelId);
        return ResponseEntity.ok().build();
    }
}
