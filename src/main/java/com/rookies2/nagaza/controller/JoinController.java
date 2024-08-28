package com.rookies2.nagaza.controller;

import com.rookies2.nagaza.dto.JoinDTO;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.service.JoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {

        this.joinService = joinService;
    }

    @PostMapping("/joinProc")
    public ResponseEntity<?> joinProc(@RequestBody JoinDTO joinDto) {
        if (joinService.joinProcess(joinDto)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("실패");
        }
    }
}
