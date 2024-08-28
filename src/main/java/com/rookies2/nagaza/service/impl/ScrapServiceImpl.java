package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.entity.*;
import com.rookies2.nagaza.repository.*;
import com.rookies2.nagaza.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrapServiceImpl implements ScrapService {

    @Autowired
    private ScrapListRepository scrapListRepository;

    @Autowired
    private ScrapMovieRepository scrapMovieRepository;

    @Autowired
    private ScrapRestaurantRepository scrapRestaurantRepository;

    @Autowired
    private ScrapHotelRepository scrapHotelRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<MovieDTO> getMovieScrapList(Integer userId) {
        ScrapList scrapList = scrapListRepository.findByUserIdAndName(userId, "movie_list")
                .orElseThrow(() -> new IllegalArgumentException("Scrap list not found"));

        return scrapMovieRepository.findByScrapList(scrapList).stream()
                .map(scrapMovie -> new MovieDTO(scrapMovie.getMovie()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDto> getRestaurantScrapList(Integer userId) {
        ScrapList scrapList = scrapListRepository.findByUserIdAndName(userId, "restaurant_list")
                .orElseThrow(() -> new IllegalArgumentException("Scrap list not found"));

        return scrapRestaurantRepository.findByScrapList(scrapList).stream()
                .map(scrapRestaurant -> new RestaurantDto(scrapRestaurant.getRestaurant()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDTO> getHotelScrapList(Integer userId) {
        ScrapList scrapList = scrapListRepository.findByUserIdAndName(userId, "hotel_list")
                .orElseThrow(() -> new IllegalArgumentException("Scrap list not found"));

        return scrapHotelRepository.findByScrapList(scrapList).stream()
                .map(scrapHotel -> new HotelDTO(scrapHotel.getHotel()))
                .collect(Collectors.toList());
    }

    @Override
    public void createMovieScrap(Integer userId, Integer movieId) {
        ScrapList scrapList = getOrCreateScrapList(userId, "movie_list");
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID"));

        ScrapMovie scrapMovie = new ScrapMovie();
        scrapMovie.setScrapList(scrapList);
        scrapMovie.setMovie(movie);
        scrapMovieRepository.save(scrapMovie);
    }

    @Override
    public void createRestaurantScrap(Integer userId, Integer restaurantId) {
        ScrapList scrapList = getOrCreateScrapList(userId, "restaurant_list");
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid restaurant ID"));

        ScrapRestaurant scrapRestaurant = new ScrapRestaurant();
        scrapRestaurant.setScrapList(scrapList);
        scrapRestaurant.setRestaurant(restaurant);
        scrapRestaurantRepository.save(scrapRestaurant);
    }

    @Override
    public void createHotelScrap(Integer userId, Integer hotelId) {
        ScrapList scrapList = getOrCreateScrapList(userId, "hotel_list");
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));

        ScrapHotel scrapHotel = new ScrapHotel();
        scrapHotel.setScrapList(scrapList);
        scrapHotel.setHotel(hotel);
        scrapHotelRepository.save(scrapHotel);
    }

    @Override
    public void deleteMovieScrap(Integer scrapListId, Integer movieId) {
        ScrapMovie scrapMovie = scrapMovieRepository.findByScrapListIdAndMovieId(scrapListId, movieId)
                .orElseThrow(() -> new IllegalArgumentException("Scrap movie not found"));
        scrapMovieRepository.delete(scrapMovie);
    }

    @Override
    public void deleteRestaurantScrap(Integer scrapListId, Integer restaurantId) {
        ScrapRestaurant scrapRestaurant = scrapRestaurantRepository.findByScrapListIdAndRestaurantId(scrapListId, restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Scrap restaurant not found"));
        scrapRestaurantRepository.delete(scrapRestaurant);
    }

    @Override
    public void deleteHotelScrap(Integer scrapListId, Integer hotelId) {
        ScrapHotel scrapHotel = scrapHotelRepository.findByScrapListIdAndHotelId(scrapListId, hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Scrap hotel not found"));
        scrapHotelRepository.delete(scrapHotel);
    }

    private ScrapList getOrCreateScrapList(Integer userId, String listName) {
        return scrapListRepository.findByUserIdAndName(userId, listName)
                .orElseGet(() -> createScrapList(userId, listName));
    }

    private ScrapList createScrapList(Integer userId, String listName) {
        User user = new User();
        user.setId(userId);
        ScrapList scrapList = new ScrapList();
        scrapList.setUser(user);
        scrapList.setName(listName);
        return scrapListRepository.save(scrapList);
    }
}
