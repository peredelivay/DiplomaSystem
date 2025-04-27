package com.mirea.diploma.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.auth.model.Role;
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}