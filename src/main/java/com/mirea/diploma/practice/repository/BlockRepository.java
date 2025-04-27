package com.mirea.diploma.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.practice.model.Block;
import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByVersionIdOrderByOrderNumber(Long versionId);
}