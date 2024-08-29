package com.rookies2.nagaza.repository;

import com.rookies2.nagaza.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ScrapListRepository extends JpaRepository<ScrapList, Integer> {
    Optional<ScrapList> findByUserIdAndName(Integer userId, String name);
}
