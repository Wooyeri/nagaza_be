package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.dto.RestaurantDetailDTO;
import com.rookies2.nagaza.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
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
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDetailDTO> getDetail(@PathVariable int id) {
        RestaurantDetailDTO dto = restaurantService.getRestaurantDetail(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<RestaurantDTO> getList(@PathVariable int id){
        RestaurantDTO dto = restaurantService.getRestaurantList(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/like/{id}")
    public ResponseEntity<RestaurantDTO> toggleRestaurantLike(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
        RestaurantDTO restaurantDto = restaurantService.toggleLike(restaurantId, userId);
        return ResponseEntity.ok(restaurantDto);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Boolean> isRestaurantLiked(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
        boolean isLiked = restaurantService.isLiked(restaurantId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<RestaurantDTO>> getLikedRestaurants(@RequestParam Integer userId) {
        List<RestaurantDTO> likedRestaurants = restaurantService.getLikeList(userId);
        return ResponseEntity.ok(likedRestaurants);
    }
}