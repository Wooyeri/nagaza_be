package com.rookies2.nagaza.service;

import com.rookies2.nagaza.dto.CustomUserDetails;
import com.rookies2.nagaza.entity.User;
import com.rookies2.nagaza.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userData = userRepository.findByUsername(username);
        log.error("@@@@@@@@@ {} ", userData);

        if (userData != null) {

            return new CustomUserDetails(userData);
        }


        return null;
    }
}
