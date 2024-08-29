package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.entity.Movie;

public class MovieMapper {
    public static MovieDTO toDto(Movie movie) {
        return new MovieDTO(movie);
    }
}

