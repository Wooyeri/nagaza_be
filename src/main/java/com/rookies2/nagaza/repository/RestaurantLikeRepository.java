package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.Restaurant;
import com.rookies2.nagaza.entity.RestaurantLike;
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantLikeRepository extends JpaRepository<RestaurantLike, Integer> {
    Optional<RestaurantLike> findByUserAndRestaurant(User user, Restaurant restaurant);
    Optional<RestaurantLike> findByUserIdAndRestaurantId(Integer userId, Integer restaurantId);
    @Query("SELECT rl.restaurant FROM RestaurantLike rl WHERE rl.user.id = :userId")
    List<Restaurant> findRestaurantsByUserId(@Param("userId") Integer userId);

}