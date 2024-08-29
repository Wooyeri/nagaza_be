package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.ScrapDTO;
import com.rookies2.nagaza.service.ScrapService;
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
    public ScrapController(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @PostMapping("/toggle")
    public ResponseEntity<?> toggleScrap(@RequestParam Integer itemId, @RequestParam Integer userId, @RequestParam String category) {
        scrapService.toggleScrap(itemId, userId, category);
        return ResponseEntity.ok().body("스크랩 상태 변경");
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

    //  TODO. 카테고리가 중복돼서 같은 값이 2개 들어옴 ( movie, movie ) 일단 임시로 이렇게 사용
    @GetMapping("/list")
    public ResponseEntity<List<ScrapDTO>> getScrapList(
            @RequestParam Integer userId,
            @RequestParam List<String> category) {
        try {
            String singleCategory = category.get(0);
            List<ScrapDTO> scrapList = scrapService.getScrapList(userId, singleCategory);
            return ResponseEntity.ok(scrapList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
