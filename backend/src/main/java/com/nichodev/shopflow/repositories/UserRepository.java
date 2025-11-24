package com.nichodev.shopflow.repositories;

import com.nichodev.shopflow.models.User;
import com.nichodev.shopflow.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
