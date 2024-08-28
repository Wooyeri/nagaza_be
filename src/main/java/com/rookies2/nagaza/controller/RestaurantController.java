package com.rookies2.nagaza.controller;

<<<<<<< HEAD
import com.rookies2.nagaza.dto.RestaurantDTO;
import com.rookies2.nagaza.dto.RestaurantDetailDTO;
import com.rookies2.nagaza.entity.Restaurant;
=======
import com.rookies2.nagaza.dto.RestaurantDto;
>>>>>>> origin/feature/403/Success
import com.rookies2.nagaza.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> origin/feature/403/Success
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

<<<<<<< HEAD
    /**
     * 모든 레스토랑을 조회하는 엔드포인트입니다.
     *
     * @return 모든 RestaurantDTO의 목록
     */
    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    /**
     * 특정 ID에 해당하는 레스토랑을 조회하는 엔드포인트입니다.
     *
     * @param id 조회할 레스토랑의 ID
     * @return 조회된 RestaurantDetailDTO 또는 null
     */
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDetailDTO> getRestaurantDetail(@PathVariable Integer id) {
        RestaurantDetailDTO restaurant = restaurantService.getRestaurantDetailById(id);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }

    /**
     * 특정 레스토랑의 좋아요 수를 1 증가시키는 엔드포인트입니다.
     *
     * @param id 좋아요 수를 증가시킬 레스토랑의 ID
     */
    @PostMapping("/{id}/like")
    public void incrementLikeCount(@PathVariable Integer id) {
        Restaurant restaurant = restaurantService.getRestaurantEntityById(id);
        if (restaurant != null) {
            restaurantService.incrementLikeCount(restaurant);
        }
    }

    /**
     * 특정 레스토랑의 좋아요 수를 1 감소시키는 엔드포인트입니다.
     *
     * @param id 좋아요 수를 감소시킬 레스토랑의 ID
     */
    @PostMapping("/{id}/unlike")
    public void decrementLikeCount(@PathVariable Integer id) {
        Restaurant restaurant = restaurantService.getRestaurantEntityById(id);
        if (restaurant != null) {
            restaurantService.decrementLikeCount(restaurant);
        }
    }
}
=======
    @GetMapping("/test/{id}")
    public ResponseEntity<RestaurantDto> getList(@PathVariable int id){
        RestaurantDto dto = restaurantService.getRestaurantList(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/like/{id}")
    public ResponseEntity<RestaurantDto> toggleRestaurantLike(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
        RestaurantDto restaurantDto = restaurantService.toggleLike(restaurantId, userId);
        return ResponseEntity.ok(restaurantDto);
    }

//    @GetMapping("/like/{id}")
//    public ResponseEntity<Boolean> isRestaurantLiked(@PathVariable("id") Integer restaurantId, @RequestParam Integer userId) {
//        boolean isLiked = restaurantService.isLiked(restaurantId, userId);
//        return ResponseEntity.ok(isLiked);
//    }
}
>>>>>>> origin/feature/403/Success
