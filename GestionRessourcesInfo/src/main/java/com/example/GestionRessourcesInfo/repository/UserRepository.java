package com.example.GestionRessourcesInfo.repository;

import com.example.GestionRessourcesInfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
