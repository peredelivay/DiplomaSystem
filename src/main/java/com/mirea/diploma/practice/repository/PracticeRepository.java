package com.mirea.diploma.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.practice.model.Practice;
import java.util.List;

public interface PracticeRepository extends JpaRepository<Practice, Long> {
    List<Practice> findByStudentId(Long studentId);
}