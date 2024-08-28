package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.ScrapHotel;
import com.rookies2.nagaza.entity.ScrapList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScrapHotelRepository extends JpaRepository<ScrapHotel, Integer> {
    List<ScrapHotel> findByScrapList(ScrapList scrapList);
    Optional<ScrapHotel> findByScrapListIdAndHotelId(Integer scrapListId, Integer hotelId);
}
