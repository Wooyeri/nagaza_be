package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.ScrapDTO;
import com.rookies2.nagaza.entity.ScrapHotel;
import com.rookies2.nagaza.entity.ScrapMovie;
import com.rookies2.nagaza.entity.ScrapRestaurant;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.repository.*;
import com.rookies2.nagaza.service.ScrapService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScrapServiceImpl implements ScrapService {

    @Autowired
    private ScrapRestaurantRepository scrapRestaurantRepository;
    @Autowired
    private ScrapMovieRepository scrapMovieRepository;
    @Autowired
    private ScrapHotelRepository scrapHotelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void toggleScrap(Integer itemId, Integer userId, String category) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        //  const category = 'movie'; 프론트에서 이런식으로 카테고리마다 설정 ...

        switch (category) {
            case "movie":
                Optional<ScrapMovie> existingMovieScrap = scrapMovieRepository.findByUserAndMovieId(user, itemId);
                if (existingMovieScrap.isPresent()) {
                    scrapMovieRepository.delete(existingMovieScrap.get());
                } else {
                    ScrapMovie newMovieScrap = new ScrapMovie(user, movieRepository.findById(itemId).orElseThrow());
                    scrapMovieRepository.save(newMovieScrap);
                }
                break;

            case "hotel":
                Optional<ScrapHotel> existingHotelScrap = scrapHotelRepository.findByUserAndHotelId(user, itemId);
                if (existingHotelScrap.isPresent()) {
                    scrapHotelRepository.delete(existingHotelScrap.get());
                } else {
                    ScrapHotel newHotelScrap = new ScrapHotel(user, hotelRepository.findById(itemId).orElseThrow());
                    scrapHotelRepository.save(newHotelScrap);
                }
                break;

            case "restaurant":
                Optional<ScrapRestaurant> existingRestaurantScrap = scrapRestaurantRepository.findByUserAndRestaurantId(user, itemId);
                if (existingRestaurantScrap.isPresent()) {
                    scrapRestaurantRepository.delete(existingRestaurantScrap.get());
                } else {
                    ScrapRestaurant newRestaurantScrap = new ScrapRestaurant(user, restaurantRepository.findById(itemId).orElseThrow());
                    scrapRestaurantRepository.save(newRestaurantScrap);
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid category");
        }
    }

    @Override
    public List<ScrapDTO> getScrapList(Integer userId, String category) {
        switch (category) {
            case "movie":
                List<ScrapMovie> movieScraps = scrapMovieRepository.findByUserId(userId);
                return movieScraps.stream().map(this::convertToDto).collect(Collectors.toList());

            case "hotel":
                List<ScrapHotel> hotelScraps = scrapHotelRepository.findByUserId(userId);
                return hotelScraps.stream().map(this::convertToDto).collect(Collectors.toList());

            case "restaurant":
                List<ScrapRestaurant> restaurantScraps = scrapRestaurantRepository.findByUserId(userId);
                return restaurantScraps.stream().map(this::convertToDto).collect(Collectors.toList());

            default:
                throw new IllegalArgumentException("Invalid category");
        }
    }
    private ScrapDTO convertToDto(ScrapMovie scrapMovie) {
        ScrapDTO dto = new ScrapDTO();
        dto.setId(scrapMovie.getId());
        dto.setTitle(scrapMovie.getMovie().getTitle());
//        dto.setCategory("movie");
        dto.setPosterUrl(scrapMovie.getMovie().getPosterUrl());
        // 리뷰요약을 설명으로 대체할 계획
        dto.setDescription(scrapMovie.getMovie().getReviewSummary());
        return dto;
    }
    private ScrapDTO convertToDto(ScrapHotel scrapHotel) {
        ScrapDTO dto = new ScrapDTO();
        dto.setId(scrapHotel.getId());
        dto.setTitle(scrapHotel.getHotel().getName());
//        dto.setCategory("hotel");
        dto.setPosterUrl(scrapHotel.getHotel().getPosterUrl());
        // 리뷰요약을 설명으로 대체할 계획
        dto.setDescription(scrapHotel.getHotel().getReviewSummary());
        return dto;
    }

    private ScrapDTO convertToDto(ScrapRestaurant scrapRestaurant) {
        ScrapDTO dto = new ScrapDTO();
        dto.setId(scrapRestaurant.getId());
        dto.setTitle(scrapRestaurant.getRestaurant().getName());
//        dto.setCategory("restaurant");
        dto.setPosterUrl(scrapRestaurant.getRestaurant().getPosterUrl());
        // 리뷰요약을 설명으로 대체할 계획
        dto.setDescription(scrapRestaurant.getRestaurant().getReviewSummary());
        return dto;
    }
}
