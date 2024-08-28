package com.rookies2.nagaza.repository;
<<<<<<< HEAD
=======

>>>>>>> e18b0e4535541d9dda35cd83c2c8bc2837c8666e
import com.rookies2.nagaza.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsByUsername(String username);

    User findByUsername(String username);
}
