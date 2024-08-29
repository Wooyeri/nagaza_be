package com.rookies2.nagaza.service.impl;

import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.entity.Restaurant;
import com.rookies2.nagaza.entity.RestaurantLike;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.mapper.RestaurantMapper;
import com.rookies2.nagaza.repository.RestaurantLikeRepository;
import com.rookies2.nagaza.repository.RestaurantRepository;
import com.rookies2.nagaza.repository.UserRepository;
import com.rookies2.nagaza.service.LikeService;
import com.rookies2.nagaza.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService, LikeService<RestaurantDto> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantLikeRepository restaurantLikeRepository;

    @Autowired
    private UserRepository userRepository;

    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantServiceImpl(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public RestaurantDto getRestaurantList(int id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        return new RestaurantDto(restaurant);
    }

    @Override
    public RestaurantDto toggleLike(Integer restaurantId, Integer userId) {
        // 식당과 유저 엔티티를 가져옵니다.
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // 식당 좋아요를 체크합니다.
        Optional<RestaurantLike> existingLike = restaurantLikeRepository.findByUserAndRestaurant(user, restaurant);

        if (existingLike.isPresent()) {
            // 이미 좋아요가 존재하면 삭제하고 좋아요 수를 감소시킵니다.
            restaurantLikeRepository.delete(existingLike.get());
            restaurant.setLikeCount(restaurant.getLikeCount() - 1);
        } else {
            // 좋아요가 없으면 새로 추가하고 좋아요 수를 증가시킵니다.
            RestaurantLike newLike = new RestaurantLike(user, restaurant);
            restaurantLikeRepository.save(newLike);
            restaurant.setLikeCount(restaurant.getLikeCount() + 1);
        }

        // 변경된 좋아요 수를 저장합니다.
        restaurantRepository.save(restaurant);

        // DTO로 변환해서 반환합니다.
        return new RestaurantDto(restaurant);
    }

    @Override
    public boolean isLiked(Integer restaurantId, Integer userId) {
        // 특정 식당과 사용자 ID를 기준으로 좋아요 여부를 체크합니다.
        return restaurantLikeRepository.findByUserIdAndRestaurantId(userId, restaurantId).isPresent();
    }

    @Override
    public List<RestaurantDto> getLikeList(Integer userId) {
        List<Restaurant> likedRestaurants = restaurantLikeRepository.findRestaurantsByUserId(userId);
        return likedRestaurants.stream()
                .map(restaurant -> restaurantMapper.toDto(restaurant))
                .collect(Collectors.toList());
    }
}