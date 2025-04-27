package com.mirea.diploma.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.chat.model.Chat;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Optional<Chat> findByStudentId(Long studentId);
}