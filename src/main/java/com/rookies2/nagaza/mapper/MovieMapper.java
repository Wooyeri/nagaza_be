package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toEntity(MovieDTO movieDto);
    MovieDTO toDto(Movie movie);
}
