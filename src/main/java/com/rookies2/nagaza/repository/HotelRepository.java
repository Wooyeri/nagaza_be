package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
