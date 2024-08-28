package com.rookies2.nagaza.dto;

import lombok.Data;

@Data
public class MovieDetailDTO extends MovieDTO {
    private String director;
    private String reviewSummary;

    // Getters and Setters
}
