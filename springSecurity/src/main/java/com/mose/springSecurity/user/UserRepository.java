package com.mose.springSecurity.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Integer,User> {
    Optional<User> findByEmail(String email);
}
