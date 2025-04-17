package com.mirea.diploma.practice.repository;

import com.mirea.diploma.practice.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
