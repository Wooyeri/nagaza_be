package com.rookies2.nagaza.dto;

import lombok.Data;

import java.util.List;
@Data
public class ScrapListDTO {
    private Integer id;
    private String name;
    private List<MovieDTO> movies;
    // Getters and Setters
}
