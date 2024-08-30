package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Hotel;
import com.rookies2.nagaza.entity.HotelLike;
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface HotelLikeRepository extends JpaRepository<HotelLike, Integer> {
    Optional<HotelLike> findByUserAndHotel(User user, Hotel hotel);
    Optional<HotelLike> findByUserIdAndHotelId(Integer userId, Integer hotelId);
    @Query("SELECT hl.hotel FROM HotelLike hl WHERE hl.user.id = :userId")
    List<Hotel> findHotelByUserId(@Param("userId") Integer userId);
}
