package com.mirea.diploma.chat.repository;

import com.mirea.diploma.chat.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    Conversation findByStudentId(Long studentId);
}
