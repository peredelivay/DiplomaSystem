package com.mirea.diploma.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.auth.model.User;
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}