package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.RestaurantDetailDTO;
import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    /**
     * 모든 레스토랑을 조회하는 엔드포인트입니다.
     *
     * @return 모든 RestaurantDTO의 목록
     */
    @GetMapping
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDetailDTO> getDetail(@PathVariable int id) {
        RestaurantDetailDTO dto = restaurantService.getRestaurantDetail(id);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/like/{id}")
    public ResponseEntity<RestaurantDto> toggleRestaurantLike(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
        RestaurantDto restaurantDto = restaurantService.toggleLike(restaurantId, userId);
        return ResponseEntity.ok(restaurantDto);
    }

// @GetMapping("/like/{id}")
// public ResponseEntity<Boolean> isRestaurantLiked(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
// boolean isLiked = restaurantService.isLiked(restaurantId, userId);
// return ResponseEntity.ok(isLiked);
// }
}