package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.entity.ScrapList;
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

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTO>> getMovieScraps(@AuthenticationPrincipal User user) {
        List<MovieDTO> scrapList = scrapService.getMovieScrapList(user.getId());
        return ResponseEntity.ok(scrapList);
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> getHotelScraps(@AuthenticationPrincipal User user) {
        List<HotelDTO> scrapList = scrapService.getHotelScrapList(user.getId());
        return ResponseEntity.ok(scrapList);
    }

    @PostMapping("/movie")
    public ResponseEntity<Void> addMovieScrap(@AuthenticationPrincipal User user, @RequestBody MovieDTO movieDto) {
        scrapService.createMovieScrap(user.getId(), movieDto.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/hotel")
    public ResponseEntity<Void> addHotelScrap(@AuthenticationPrincipal User user, @RequestBody HotelDTO hotelDto) {
        scrapService.createHotelScrap(user.getId(), hotelDto.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<Void> removeMovieScrap(@AuthenticationPrincipal User user, @PathVariable Integer movieId) {
        ScrapList scrapList = scrapService.getOrCreateScrapList(user.getId(), "movie_list");
        scrapService.deleteMovieScrap(scrapList.getId(), movieId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<Void> removeHotelScrap(@AuthenticationPrincipal User user, @PathVariable Integer hotelId) {
        ScrapList scrapList = scrapService.getOrCreateScrapList(user.getId(), "hotel_list");
        scrapService.deleteHotelScrap(scrapList.getId(), hotelId);
        return ResponseEntity.ok().build();
    }
}




