package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.HotelDetailDTO;
import com.rookies2.nagaza.entity.Hotel;
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

    /**
     * 모든 호텔을 조회하는 엔드포인트입니다.
     *
     * @return 모든 HotelDTO의 목록
     */
    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.getAllHotels();
    }

    /**
     * 특정 ID에 해당하는 호텔을 조회하는 엔드포인트입니다.
     *
     * @param id 조회할 호텔의 ID
     * @return 조회된 HotelDetailDTO 또는 null
     */

    @GetMapping("/{id}")
    public ResponseEntity<HotelDetailDTO> getHotelDetail(@PathVariable Integer id) {
        HotelDetailDTO hotel = hotelService.getHotelDetailById(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @PostMapping("/like/{id}")
    public ResponseEntity<HotelDTO> toggleHotelLike(@PathVariable("id") Integer hotelId, @RequestParam Integer userId) {
        HotelDTO hotelDto = hotelService.toggleLike(hotelId, userId);
        return ResponseEntity.ok(hotelDto);
    }

    @GetMapping("/like/{id}")
    public ResponseEntity<Boolean> isHotelLiked(@PathVariable("id") Integer hotelId, @RequestParam Integer userId) {
        boolean isLiked = hotelService.isLiked(hotelId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/likes")
    public ResponseEntity<List<HotelDTO>> getLikedHotels(@RequestParam Integer userId) {
        List<HotelDTO> likedHotels = hotelService.getLikeList(userId);
        return ResponseEntity.ok(likedHotels);
    }
}

//=======
//
//    @Autowired
//    private HotelService hotelService;
//
//    /**
//     * 모든 호텔을 조회하는 엔드포인트입니다.
//     *
//     * @return 모든 HotelDTO의 목록
//     */
//    @GetMapping
//    public List<HotelDTO> getAllHotels() {
//        return hotelService.getAllHotels();
//    }
//
//    /**
//     * 특정 ID에 해당하는 호텔을 조회하는 엔드포인트입니다.
//     *
//     * @param id 조회할 호텔의 ID
//     * @return 조회된 HotelDetailDTO 또는 null
//     */
//
//    @GetMapping("/{id}")
//    public ResponseEntity<HotelDetailDTO> getHotelDetail(@PathVariable Integer id) {
//        HotelDetailDTO hotel = hotelService.getHotelDetailById(id);
//        if (hotel == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(hotel);
//    }
//
//    /**
//     * 특정 호텔의 좋아요 수를 1 증가시키는 엔드포인트입니다.
//     *
//     * @param id 좋아요 수를 증가시킬 호텔의 ID
//     */
//    @PostMapping("/{id}/like")
//    public void incrementLikeCount(@PathVariable Integer id) {
//        Hotel hotel = hotelService.getHotelEntityById(id);
//        if (hotel != null) {
//            hotelService.incrementLikeCount(hotel);
//        }
//    }
//
//    /**
//     * 특정 호텔의 좋아요 수를 1 감소시키는 엔드포인트입니다.
//     *
//     * @param id 좋아요 수를 감소시킬 호텔의 ID
//     */
//    @PostMapping("/{id}/unlike")
//    public void decrementLikeCount(@PathVariable Integer id) {
//        Hotel hotel = hotelService.getHotelEntityById(id);
//        if (hotel != null) {
//            hotelService.decrementLikeCount(hotel);
//        }
//    }
//}

