package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.RestaurantDto;
import com.rookies2.nagaza.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/test/{id}")
    public ResponseEntity<RestaurantDto> getList(@PathVariable int id){
        RestaurantDto dto = restaurantService.getRestaurantList(id);

        return ResponseEntity.ok(dto);
    }
}
