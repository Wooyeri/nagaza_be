package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.MovieDTO;
import com.rookies2.nagaza.dto.ScrapListDTO;
import com.rookies2.nagaza.entity.ScrapList;
import com.rookies2.nagaza.entity.ScrapMovie;
import com.rookies2.nagaza.repository.ScrapListRepository;
import com.rookies2.nagaza.repository.ScrapMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrapService {

    @Autowired
    private ScrapListRepository scrapListRepository;

    @Autowired
    private ScrapMovieRepository scrapMovieRepository;

    /**
     * 모든 ScrapList 엔티티를 조회하고 ScrapListDTO로 변환하여 반환합니다.
     *
     * @return 모든 ScrapListDTO 목록
     */
    public List<ScrapListDTO> getAllScrapLists() {
        return scrapListRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * 주어진 이름으로 ScrapList를 조회하고 ScrapListDTO로 변환하여 반환합니다.
     *
     * @param name 조회할 ScrapList의 이름
     * @return 조회된 ScrapListDTO 또는 null
     */
    public ScrapListDTO getScrapListByName(String name) {
        ScrapList scrapList = scrapListRepository.findByName(name);
        return scrapList != null ? convertToDTO(scrapList) : null;
    }

    /**
     * ScrapList 엔티티를 ScrapListDTO로 변환합니다.
     *
     * @param scrapList 변환할 ScrapList 엔티티
     * @return 변환된 ScrapListDTO
     */
    private ScrapListDTO convertToDTO(ScrapList scrapList) {
        ScrapListDTO dto = new ScrapListDTO();
        dto.setId(scrapList.getId());
        dto.setName(scrapList.getName());
        dto.setMovies(scrapList.getScrapMovies().stream()
                .map(scrapMovie -> {
                    MovieDTO movieDTO = new MovieDTO();
                    movieDTO.setId(scrapMovie.getMovie().getId());
                    movieDTO.setTitle(scrapMovie.getMovie().getTitle());
                    movieDTO.setPosterUrl(scrapMovie.getMovie().getPosterUrl());
                    return movieDTO;
                })
                .collect(Collectors.toList()));
        // hotels와 restaurants도 비슷하게 처리
        return dto;
    }

    /**
     * 새로운 ScrapList를 생성합니다.
     *
     * @param scrapList 생성할 ScrapList 엔티티
     * @return 생성된 ScrapList 엔티티
     */
    public ScrapList createScrapList(ScrapList scrapList) {
        return scrapListRepository.save(scrapList);
    }

    /**
     * ScrapMovie 엔티티를 저장합니다.
     *
     * @param scrapMovie 저장할 ScrapMovie 엔티티
     * @return 저장된 ScrapMovie 엔티티
     */
    public ScrapMovie saveScrapMovie(ScrapMovie scrapMovie) {
        return scrapMovieRepository.save(scrapMovie);
    }

    /**
     * 주어진 ID에 해당하는 ScrapMovie 엔티티를 삭제합니다.
     *
     * @param id 삭제할 ScrapMovie의 ID
     */
    public void deleteScrapMovie(Integer id) {
        scrapMovieRepository.deleteById(id);
    }
}


