package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapHotel;
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapHotelRepository extends JpaRepository<ScrapHotel, Integer> {
    Optional<ScrapHotel> findByUserAndHotelId (User user, Integer hotelId);
    List<ScrapHotel> findByUserId(Integer userId);
}
