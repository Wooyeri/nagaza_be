package com.rookies2.nagaza.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDTO {
    private String email;
    private String nickname;
    private String username;
    private String password;
}
