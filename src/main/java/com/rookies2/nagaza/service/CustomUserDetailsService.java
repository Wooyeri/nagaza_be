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
<<<<<<< HEAD
=======
        log.error("@@@@@@@@@ {} ", userData);
>>>>>>> e18b0e4535541d9dda35cd83c2c8bc2837c8666e

        if (userData != null) {

            return new CustomUserDetails(userData);
        }


        return null;
    }
}
