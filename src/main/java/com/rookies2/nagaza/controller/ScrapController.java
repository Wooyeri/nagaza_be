package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.ScrapListDTO;
import com.rookies2.nagaza.entity.ScrapList;
import com.rookies2.nagaza.entity.ScrapMovie;
import com.rookies2.nagaza.service.ScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scrap")
public class ScrapController {

    @Autowired
    private ScrapService scrapService;

    /**
     * 모든 스크랩 리스트를 조회하는 엔드포인트입니다.
     *
     * @return 모든 ScrapListDTO의 목록
     */
    @GetMapping
    public List<ScrapListDTO> getAllScrapLists() {
        return scrapService.getAllScrapLists();
    }

    /**
     * 이름으로 스크랩 리스트를 조회하는 엔드포인트입니다.
     *
     * @param name 조회할 ScrapList의 이름
     * @return 조회된 ScrapListDTO 또는 null
     */
    @GetMapping("/list")
    public ScrapListDTO getScrapListByName(@RequestParam String name) {
        return scrapService.getScrapListByName(name);
    }

    /**
     * 새로운 ScrapList를 생성하는 엔드포인트입니다.
     *
     * @param scrapList 생성할 ScrapList 엔티티
     * @return 생성된 ScrapList 엔티티
     */
    @PostMapping("/list")
    public ScrapList createScrapList(@RequestBody ScrapList scrapList) {
        return scrapService.createScrapList(scrapList);
    }

    /**
     * ScrapMovie 항목을 저장하는 엔드포인트입니다.
     *
     * @param scrapMovie 저장할 ScrapMovie 엔티티
     * @return 저장된 ScrapMovie 엔티티
     */
    @PostMapping("/movie")
    public ScrapMovie saveScrapMovie(@RequestBody ScrapMovie scrapMovie) {
        return scrapService.saveScrapMovie(scrapMovie);
    }

    /**
     * 주어진 ID에 해당하는 ScrapMovie 항목을 삭제하는 엔드포인트입니다.
     *
     * @param id 삭제할 ScrapMovie의 ID
     */
    @DeleteMapping("/movie/{id}")
    public void deleteScrapMovie(@PathVariable Integer id) {
        scrapService.deleteScrapMovie(id);
    }
}
