package com.mirea.diploma.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.practice.model.Version;
import java.util.List;

public interface VersionRepository extends JpaRepository<Version, Long> {
    List<Version> findByPracticeIdOrderByVersionNumber(Long practiceId);
}