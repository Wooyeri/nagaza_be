package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.HotelDTO;
import com.rookies2.nagaza.dto.MovieDTO;
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
    private ScrapHotelRepository scrapHotelRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<MovieDTO> getMovieScrapList(Integer userId) {
        ScrapList scrapList = getScrapListByName(userId, "movie_list");
        return scrapMovieRepository.findByScrapList(scrapList).stream()
                .map(scrapMovie -> new MovieDTO(scrapMovie.getMovie()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDTO> getHotelScrapList(Integer userId) {
        ScrapList scrapList = getScrapListByName(userId, "hotel_list");
        return scrapHotelRepository.findByScrapList(scrapList).stream()
                .map(scrapHotel -> new HotelDTO(scrapHotel.getHotel()))
                .collect(Collectors.toList());
    }


    @Override
    public void createMovieScrap(Integer userId, Integer movieId) {
        ScrapList scrapList = getOrCreateScrapList(userId, "movie_list");
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID"));

        if (scrapMovieRepository.existsByScrapListAndMovie(scrapList, movie)) {
            throw new IllegalArgumentException("This movie is already scrapped.");
        }

        ScrapMovie scrapMovie = new ScrapMovie();
        scrapMovie.setScrapList(scrapList);
        scrapMovie.setMovie(movie);
        scrapMovieRepository.save(scrapMovie);
    }

    @Override
    public void createHotelScrap(Integer userId, Integer hotelId) {
        ScrapList scrapList = getOrCreateScrapList(userId, "hotel_list");
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hotel ID"));

        if (scrapHotelRepository.existsByScrapListAndHotel(scrapList, hotel)) {
            throw new IllegalArgumentException("This hotel is already scrapped.");
        }

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
        ScrapList scrapList = new ScrapList();

        User user = new User();  // 새로운 User 객체 생성
        user.setId(userId);  // User 객체에 ID를 직접 설정

        scrapList.setUser(user);  // ScrapList에 User 설정
        scrapList.setName(listName);  // ScrapList에 이름 설정

        return scrapListRepository.save(scrapList);  // ScrapList 저장 후 반환
    }


    private ScrapList getScrapListByName(Integer userId, String name) {
        return scrapListRepository.findByUserIdAndName(userId, name)
                .orElseThrow(() -> new IllegalArgumentException("Scrap list not found"));
    }
}

