package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.JoinDTO;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(JoinDTO joinDTO) {
        String nickname = joinDTO.getNickname();
        String username = joinDTO.getUsername();
        String password = joinDTO.getPassword();
        String email = joinDTO.getEmail();
        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {

            return;
        }

        User data = new User();

        data.setEmail(email);
        data.setNickname(nickname);
        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}
