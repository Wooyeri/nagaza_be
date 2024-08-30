package com.rookies2.nagaza.dto;

import lombok.Data;


@Data
public class ScrapDTO {
    private Integer id;
    private String title;
    private String category;
    private String posterUrl;
    private String description;

//    private ScrapDTO convertToDto(ScrapMovie scrapMovie) {
//        ScrapDTO dto = new ScrapDTO();
//        dto.setId(scrapMovie.getId());
//        dto.setTitle(scrapMovie.getMovie().getTitle()); // 영화 제목
//        dto.setCategory("movie");
//        dto.setImageUrl(scrapMovie.getMovie().getImageUrl()); // 이미지 URL
//        dto.setDescription(scrapMovie.getMovie().getDescription()); // 설명
//        dto.setCreatedDate(scrapMovie.getCreatedDate());
//        return dto;
//    }
}
