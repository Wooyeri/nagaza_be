package com.rookies2.nagaza.mapper;

import com.rookies2.nagaza.dto.MovieDto;
import com.rookies2.nagaza.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie toEntity(MovieDto movieDto);
    MovieDto toDto(Movie movie);
}
