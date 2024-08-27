package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.JoinDTO;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean joinProcess(JoinDTO joinDto) {
        // 동일한 username을 사용하고 있는지 확인
        if (userRepository.existsByUsername(joinDto.getUsername()))
            return false;


        // 패스워드와 패스워드 확인이 일치하는지 확인
//        if (!joinDto.checkPassword())
//            return false;

        User user = new ModelMapper().map(joinDto, User.class);


//         패스워드 암호화 처리 및 역할을 설정
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");    // 사용자 역할을 구분하는 문자로 "ROLE_" 접두어를 사용



//         UserEntity를 저장
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


//    public void joinProcess(JoinDTO joinDTO) {
//
//        String username = joinDTO.getUsername();
//        String password = joinDTO.getPassword();
//        String nickname = joinDTO.getNickname();
//        String email = joinDTO.getEmail();
//
//        Boolean isExist = userRepository.existsByUsername(username);
//
//        if (isExist) {
//
//            return;
//        }
//
//        User data = new User();
//
//        data.setUsername(username);
//        data.setPassword(bCryptPasswordEncoder.encode(password));
//        data.setRole("ROLE_ADMIN");
//        data.setEmail(email);
//        data.setNickname(nickname);
//
//        userRepository.save(data);
//    }
//}
