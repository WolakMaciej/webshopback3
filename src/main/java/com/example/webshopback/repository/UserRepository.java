package com.example.webshopback.repository;

import com.example.webshopback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByToken(String token);

    boolean existsUserByUsername(String username);

}
