package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.ScrapDTO;
import com.rookies2.nagaza.jwt.JWTUtil;
import com.rookies2.nagaza.service.ScrapService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/scrap")
public class ScrapController {

    private final ScrapService scrapService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    public ScrapController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @PostMapping("/toggle")
    public ResponseEntity<?> toggleScrap(@RequestParam Integer itemId, @RequestParam String category, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);

        scrapService.toggleScrap(itemId, userId, category);
        return ResponseEntity.ok().body("스크랩 상태 변경");
    }
    @GetMapping("/toggle")
    public ResponseEntity<Boolean> isScrap(
            @RequestParam Integer itemId,
            @RequestParam String category,
            HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization").substring(7);
            Integer userId = jwtUtil.getUserId(token);

            boolean isScraped = scrapService.isScrap(itemId, userId, category);
            return ResponseEntity.ok(isScraped);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ScrapDTO>> getScrapList(
            @RequestParam String category, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization").substring(7);
            Integer userId = jwtUtil.getUserId(token);

            List<ScrapDTO> scrapList = scrapService.getScrapList(userId, category);
            return ResponseEntity.ok(scrapList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    // 각 카테고리별 조회 엔드포인트 추가
    @GetMapping("/movies")
    public ResponseEntity<List<ScrapDTO>> getMovieScraps(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);
        List<ScrapDTO> scrapList = scrapService.getMovieScraps(userId);
        return ResponseEntity.ok(scrapList);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<ScrapDTO>> getHotelScraps(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);
        List<ScrapDTO> scrapList = scrapService.getHotelScraps(userId);
        return ResponseEntity.ok(scrapList);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<ScrapDTO>> getRestaurantScraps(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        Integer userId = jwtUtil.getUserId(token);
        List<ScrapDTO> scrapList = scrapService.getRestaurantScraps(userId);
        return ResponseEntity.ok(scrapList);
    }
}


    //    @GetMapping("/list")
//    public ResponseEntity<List<ScrapDTO>> getScrapList(
//            @RequestParam Integer userId,
//            @RequestParam String category) {
//        try {
//            List<ScrapDTO> scrapList = scrapService.getScrapList(userId, category);
//            return ResponseEntity.ok(scrapList);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
